package id.lukyana.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class SoalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        val rg_nama: RadioGroup = findViewById(R.id.rg_soal1)
        val rg_agama: RadioGroup = findViewById(R.id.rg_soal2)
        val btn: Button = findViewById(R.id.submit)

        btn.setOnClickListener {
            if (rg_nama.checkedRadioButtonId > 0 && rg_agama.checkedRadioButtonId > 0) {
                var nilai = ""
                when (rg_nama.checkedRadioButtonId) {
                    R.id.rb_luky -> nilai = "Luky Ana Adi Pratama"
                    R.id.rb_ridian -> nilai = "Ridian"
                    R.id.rb_marcell -> nilai = "Marcell"
                    R.id.rb_nugroho -> nilai = "Nugroho"
                    R.id.rb_fahrul -> nilai = "Fahrul"
                }

                var agama = ""
                when (rg_agama.checkedRadioButtonId) {
                    R.id.rb_islam -> agama = "islam"
                    R.id.rb_kristen -> agama = "kristen"
                    R.id.rb_katolik -> agama = "katolik"
                    R.id.rb_hindu -> agama = "hindu"
                    R.id.rb_budha -> agama = "budha"
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_KEY, nilai)
                resultIntent.putExtra(EXTRA_AGAMA, agama)
                setResult(CODE, resultIntent)
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_KEY = "extra_key"
        const val EXTRA_AGAMA = "extra_agama"
        const val CODE = 100
    }
}