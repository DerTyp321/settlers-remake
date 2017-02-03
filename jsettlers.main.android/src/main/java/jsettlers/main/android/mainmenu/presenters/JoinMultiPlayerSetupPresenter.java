package jsettlers.main.android.mainmenu.presenters;

import jsettlers.common.menu.IJoinPhaseMultiplayerGameConnector;
import jsettlers.common.menu.IMultiplayerListener;
import jsettlers.common.menu.IStartingGame;
import jsettlers.main.android.core.GameStarter;
import jsettlers.main.android.mainmenu.navigation.MainMenuNavigator;
import jsettlers.main.android.mainmenu.views.JoinMultiPlayerSetupView;

/**
 * Created by tompr on 22/01/2017.
 */

public class JoinMultiPlayerSetupPresenter implements IMultiplayerListener {
    private final JoinMultiPlayerSetupView view;
    private final GameStarter gameStarter;
    private final MainMenuNavigator navigator;

    private IJoinPhaseMultiplayerGameConnector connector;

    public JoinMultiPlayerSetupPresenter(JoinMultiPlayerSetupView view, GameStarter gameStarter, MainMenuNavigator navigator) {
        this.view = view;
        this.gameStarter = gameStarter;
        this.navigator = navigator;

        connector = gameStarter.getJoinPhaseMultiplayerConnector();
        connector.setMultiplayerListener(this);
    }

    public void setReady(boolean ready) {
        connector.setReady(ready);
    }

    public void viewFinished() {
        if (gameStarter.getStartingGame() == null) {
            abort();
        }
    }

    public void dispose() {
        connector.setMultiplayerListener(null);
    }

    private void abort() {
        connector.abort();
        gameStarter.setJoinPhaseMultiPlayerConnector(null);
    }

    /**
     * IMultiplayerListener implementation
     */
    @Override
    public void gameAborted() {
        //TODO pop
    }

    @Override
    public void gameIsStarting(IStartingGame game) {
        gameStarter.setJoinPhaseMultiPlayerConnector(null);
        gameStarter.setStartingGame(game);
        navigator.showGame();
    }
}
