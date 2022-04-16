package ge.gogichaishvili.lessonhomework3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ge.gogichaishvili.lessonhomework3.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val strUser: String = intent.getStringExtra("username").toString()
        binding.tvHello.text = "${getString(R.string.hello)} $strUser"

        binding.vRightCard.setOnClickListener {
            val intent = Intent(this, WithDrawActivity::class.java)
            startActivity(intent)
        }
    }
}