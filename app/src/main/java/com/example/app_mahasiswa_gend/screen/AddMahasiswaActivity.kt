package com.example.app_mahasiswa_gend.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app_mahasiswa_gend.databinding.ActivityAddMahasiswaBinding
import com.example.app_mahasiswa_gend.helper.MahasiswaDatabaseHelper
import com.example.app_mahasiswa_gend.model.ModelMahasiswa


class AddMahasiswaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMahasiswaBinding
    private lateinit var db: MahasiswaDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MahasiswaDatabaseHelper(this)

        binding.saveButton.setOnClickListener() {
            val nama = binding.nameEditText.text.toString()
            val nim = binding.nimEditText.text.toString()
            val jurusan = binding.jurusanEditText.text.toString()
            val note = ModelMahasiswa(0, nama, nim, jurusan)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Data disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}