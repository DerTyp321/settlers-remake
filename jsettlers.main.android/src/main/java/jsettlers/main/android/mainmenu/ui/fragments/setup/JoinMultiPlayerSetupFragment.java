/*
 * Copyright (c) 2017
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package jsettlers.main.android.mainmenu.ui.fragments.setup;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;

import org.androidannotations.annotations.EFragment;

import jsettlers.main.android.R;
import jsettlers.main.android.mainmenu.factories.PresenterFactory;
import jsettlers.main.android.mainmenu.presenters.setup.JoinMultiPlayerSetupPresenter;
import jsettlers.main.android.mainmenu.viewmodels.setup.JoinMultiPlayerSetupViewModel;
import jsettlers.main.android.mainmenu.viewmodels.setup.MapSetupViewModel;
import jsettlers.main.android.mainmenu.views.JoinMultiPlayerSetupView;

/**
 * Created by tompr on 22/01/2017.
 */
@EFragment(R.layout.fragment_new_single_player_setup)
public class JoinMultiPlayerSetupFragment extends MapSetupFragment<JoinMultiPlayerSetupPresenter> implements JoinMultiPlayerSetupView {

	public static Fragment create(String mapId) {
		return JoinMultiPlayerSetupFragment_.builder().mapId(mapId).build();
	}

	@Override
	protected JoinMultiPlayerSetupPresenter createPresenter() {
		return PresenterFactory.createJoinMultiPlayerSetupPresenter(getActivity(), this, mapId);
	}

	@Override
	protected MapSetupViewModel createViewModel() {
		return ViewModelProviders.of(this, new JoinMultiPlayerSetupViewModel.Factory(getActivity(), mapId)).get(JoinMultiPlayerSetupViewModel.class);
	}

	@Override
	protected int getListItemLayoutId() {
		return R.layout.item_multiplayer_playerslot;
	}

	/**
	 * JoinMultiPlayerSetupView implementation
	 */
	@Override
	public void disableHostOnlyControls() {
		numberOfPlayersSpinner.setEnabled(false);
		startResourcesSpinner.setEnabled(false);
		peacetimeSpinner.setEnabled(false);
	}
}
