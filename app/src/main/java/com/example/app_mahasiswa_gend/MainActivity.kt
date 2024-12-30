package com.example.app_mahasiswa_gend

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_mahasiswa_gend.adapter.MahasiswaAdapter
import com.example.app_mahasiswa_gend.databinding.ActivityMainBinding
import com.example.app_mahasiswa_gend.helper.MahasiswaDatabaseHelper
import com.example.app_mahasiswa_gend.screen.AddMahasiswaActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mahasiswaAdapter: MahasiswaAdapter
    private lateinit var db: MahasiswaDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inisialisasi binding di sini
        setContentView(binding.root)
        binding.addButton.setOnClickListener(){
            val intent = Intent(this@MainActivity, AddMahasiswaActivity::class.java)
            startActivity(intent)
        }

        db = MahasiswaDatabaseHelper(this)
        mahasiswaAdapter = MahasiswaAdapter(db.getAllNotes(), this)

        binding.mahasiswaRecycleview.layoutManager = LinearLayoutManager(this)
        binding.mahasiswaRecycleview.adapter = mahasiswaAdapter
    }

    override fun onResume() {
        super.onResume()
        val mahasiswa = db.getAllNotes()
        mahasiswaAdapter.refreshData(mahasiswa)
    }
}