package ge.gogichaishvili.lessonhomework3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ge.gogichaishvili.lessonhomework3.databinding.ActivityWithDrawBinding

class WithDrawActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWithDrawBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithDrawBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.etAmount.inputType = InputType.TYPE_CLASS_NUMBER

        binding.btnWithdraw.setOnClickListener {
           if ( binding.etAmount.text.toString().trim().isEmpty()) {
               binding.etAmount.error = getString(R.string.field_required)
               binding.etAmount.setBackgroundResource(R.drawable.edittext_bg_red)
           } else {
               val intent = Intent(this, SuccessActivity::class.java)
               startActivity(intent)
           }
        }

        binding.etAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
                // empty
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.etAmount.error = null
                binding.etAmount.setBackgroundResource(R.drawable.edittext_background_drawable)
            }

            override fun afterTextChanged(s: Editable) {

            }
        })


        binding.ivArrow.setOnClickListener {
            super.onBackPressed()
        }

    }
}