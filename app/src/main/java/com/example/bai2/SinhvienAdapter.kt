package com.example.bai2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SinhVienAdapter(private var sinhVienList: List<SinhVien>) :
    RecyclerView.Adapter<SinhVienAdapter.ViewHolder>() {

    // ViewHolder quản lý các thành phần trong item
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHoTen: TextView = itemView.findViewById(R.id.tvHoTen)
        val tvMssv: TextView = itemView.findViewById(R.id.tvMssv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sinhvien, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sinhVien = sinhVienList[position]
        holder.tvHoTen.text = sinhVien.hoTen
        holder.tvMssv.text = sinhVien.mssv
    }

    override fun getItemCount(): Int {
        return sinhVienList.size
    }

    // Cập nhật danh sách sau khi tìm kiếm
    fun updateList(newList: List<SinhVien>) {
        sinhVienList = newList
        notifyDataSetChanged()
    }
}
