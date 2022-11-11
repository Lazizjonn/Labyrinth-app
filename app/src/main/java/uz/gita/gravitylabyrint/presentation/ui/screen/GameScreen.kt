package uz.gita.gravitylabyrint.presentation.ui.screen


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.gravitylabyrint.R
import uz.gita.gravitylabyrint.databinding.ScreenGameBinding
import uz.gita.gravitylabyrint.presentation.viewmodel.GameViewModel
import uz.gita.gravitylabyrint.presentation.viewmodel.impl.GameViewModelImpl
import uz.gita.gravitylabyrint.util.dp
import uz.gita.gravitylabyrint.util.scope

@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {
    private val binding by viewBinding(ScreenGameBinding::bind)
    private val viewModel: GameViewModel by viewModels<GameViewModelImpl>()
    private val args by navArgs<GameScreenArgs>()
    private val sensorService by lazy { requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    private val sensor by lazy { sensorService.getDefaultSensor(Sensor.TYPE_GYROSCOPE) }
    private var cHeight = 0
    private var cWidth = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        container.post {
            cHeight = container.height
            cWidth = container.width
            viewModel.loadByLevel(args.level)
        }
        viewModel.mapByLevelLiveData.observe(viewLifecycleOwner, mapByLevelObserver)
    }

    private val mapByLevelObserver = Observer<Array<Array<Int>>> { map ->
        map.forEachIndexed { y, row ->
            row.forEachIndexed { x, value ->
                if (value == 1) {
                    val image = ImageView(requireContext())
                    image.setImageResource(R.drawable.ic_board)
                    binding.container.addView(image)
                    image.x = x * 10.dp
                    image.y = y * 10.dp
                    val param = image.layoutParams
                    param.width = 10.dp.toInt()
                    param.height = 10.dp.toInt()
                    image.layoutParams = param
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sensorService.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause() {
        super.onPause()
        sensorService.unregisterListener(listener)
    }
    private val listener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {

        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        }

    }

}