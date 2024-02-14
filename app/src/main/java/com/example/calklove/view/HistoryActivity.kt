package com.example.calklove.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calklove.R
import com.example.calklove.remote.LoveModel
import androidx.appcompat.app.AlertDialog
import android.widget.Toast
import com.example.calklove.App
import com.example.calklove.databinding.ActivityHistoryBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private val adapter = LoveAdapter(this::OnLongClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerView.adapter = adapter
            setData()
        }
    }

    private fun OnLongClick(loveModel: LoveModel) {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите удалить текст?")
            setPositiveButton(getString(R.string.yes)) { _, _ ->
                val position = adapter.list.indexOf(loveModel)
                adapter.removeTask(position)
                GlobalScope.launch(Dispatchers.IO) {
                    App.appDatabase.loveDao().delete(loveModel)
                }
                Toast.makeText(this@HistoryActivity, "текст удален", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.dismiss()
            }
        }.create().show()
    }

    private fun setData() {
        GlobalScope.launch(Dispatchers.IO) {
            val tasks = App.appDatabase.loveDao().getAllSorted()
            withContext(Dispatchers.Main) {
                adapter.addlovs(tasks)
            }
        }
    }
}
