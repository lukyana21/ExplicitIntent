package id.lukyana.explicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var hasil: TextView
    private lateinit var hasil2: TextView

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ yuhuu ->
            if (yuhuu.resultCode == SoalActivity.CODE && yuhuu.data != null){
                val data = yuhuu.data?.getStringExtra(SoalActivity.EXTRA_KEY)
                hasil.text = data
                val data2 = yuhuu.data?.getStringExtra(SoalActivity.EXTRA_AGAMA)
                hasil2.text = data2
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.tombol1)
        val btn2: Button = findViewById(R.id.tombol2)
        val btn3: Button = findViewById(R.id.tombol3)
        val btn4: Button = findViewById(R.id.tombol4)
        val btn5: Button = findViewById(R.id.tombol5)
        hasil = findViewById(R.id.hasilActivity)
        hasil2 = findViewById(R.id.hasilActivity2)

        btn1.setOnClickListener {
            val i = Intent(this@MainActivity, ExplicitActivity::class.java)
            startActivity(i)
        }

        btn2.setOnClickListener {
            val i = Intent(this@MainActivity, PindahDenganDataActivity::class.java)
            i.putExtra(PindahDenganDataActivity.EXTRA_NAMA, "Luky")
            i.putExtra(PindahDenganDataActivity.EXTRA_UMUR, 21)
            startActivity(i)
        }

        btn3.setOnClickListener {
            val data = Biodata(
                "Luky",
                21,
                "Luky3667@gmail.com",
                "Laki"
            )

            val i = Intent(this@MainActivity, ParcelActivity::class.java)
            i.putExtra(ParcelActivity.EXTRA_BIODATA, data)
            startActivity(i)
        }

        btn4.setOnClickListener {
            val nomor = "081227062486"
            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomor"))
            startActivity(i)
        }

        btn5.setOnClickListener {
            val i = Intent(this@MainActivity, SoalActivity::class.java)
            resultLauncher.launch(i)
        }
    }
}