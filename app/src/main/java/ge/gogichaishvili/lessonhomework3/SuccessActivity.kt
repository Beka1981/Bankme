package ge.gogichaishvili.lessonhomework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ge.gogichaishvili.lessonhomework3.databinding.ActivityMainBinding
import ge.gogichaishvili.lessonhomework3.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnClose.setOnClickListener {
            this.finish()
        }
    }
}