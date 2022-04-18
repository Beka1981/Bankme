package ge.gogichaishvili.lessonhomework3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import ge.gogichaishvili.lessonhomework3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root /*
         ზედმეტი ცვლადია view  მეხსიერების ალოკაციაა ფუჭი, პირდაპირ გადააწოდე ხოლმე setContentView ს binding.root
          და ყველგნაც ეცადე ზედმეტი ცვლადების გარეშე გამოხვიდე
          */
        setContentView(view)

        binding.btnLogin.setOnClickListener {

            when {
                binding.etPhone.text.toString().trim()
                    .isEmpty() -> {
                    binding.etPhone.error = getString(R.string.field_required)
                    binding.etPhone.setBackgroundResource(R.drawable.edittext_bg_red)
                }
                binding.etPassword.text.toString().trim().isEmpty() -> {
                    binding.etPassword.error = getString(R.string.field_required)
                    binding.etPassword.setBackgroundResource(R.drawable.edittext_bg_red)
                }
                else -> {
                    if (binding.etPassword.text.toString().trim() == "admin") {
                        val intent = Intent(this, DashboardActivity::class.java)
                        intent.putExtra("username", binding.etPhone.text.toString().trim())
                        startActivity(intent)
                    } else {
                        binding.etPassword.error = getString(R.string.invalid_password) //
                        binding.etPassword.setBackgroundResource(R.drawable.edittext_bg_red)
                    }
                }
            }


            binding.etPhone.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // empty
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    binding.etPhone.error = null
                    binding.etPhone.setBackgroundResource(R.drawable.edittext_background_drawable)
                }

                override fun afterTextChanged(s: Editable) {

                }
            })


            binding.etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // empty
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    binding.etPassword.error = null
                    binding.etPassword.setBackgroundResource(R.drawable.edittext_background_drawable)
                }

                override fun afterTextChanged(s: Editable) {

                }
            })
            /*
            აქ შეგიძლია ლამბდა გამოიყენო
               binding.etPassword.doOnTextChanged { text, start, before, count ->

                           }
             */


        }

    }

}