package uz.gita.gravitylabyrint.presentation.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.gravitylabyrint.R
import uz.gita.gravitylabyrint.databinding.ScreenLevelBinding
import uz.gita.gravitylabyrint.presentation.viewmodel.LevelViewModel
import uz.gita.gravitylabyrint.presentation.viewmodel.impl.LevelViewModelImpl
import uz.gita.gravitylabyrint.util.myLog
import uz.gita.gravitylabyrint.util.scope

@AndroidEntryPoint
class LevelScreen : Fragment(R.layout.screen_level) {
    private val binding by viewBinding(ScreenLevelBinding::bind)
    private val viewModel: LevelViewModel by viewModels<LevelViewModelImpl>()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {

        level1.setOnClickListener { viewModel.openNextScreenByLevel(1) }
        level2.setOnClickListener { viewModel.openNextScreenByLevel(2) }
        level3.setOnClickListener { viewModel.openNextScreenByLevel(3) }

        viewModel.openNextScreenLiveData.observe(this@LevelScreen, openNextScreenObserver)
    }

    private val openNextScreenObserver = Observer<Int> {
        myLog("it = ${it}")
        Log.d("TTT", "${it}")
        findNavController().navigate(LevelScreenDirections.actionLevelScreenToGameScreen(it))
    }

}