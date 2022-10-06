package com.example.chapter5.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapter5.DetailActivity
import com.example.chapter5.EditDataActivity
import com.example.chapter5.databinding.ItemBinding
import com.example.chapter5.model.ResponseDataMhsItem

class MhsAdapter(var listData : List<ResponseDataMhsItem>): RecyclerView.Adapter<MhsAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNama.text =   ("Nama               : "+listData[position].nama)
        holder.binding.txtNim.text =    ("Nim                   : "+listData[position].nim)
        holder.binding.txtJk.text =     ("Jenis Kelamin : "+listData[position].jk)
        holder.binding.txtAlamat.text = ("Alamat              : "+listData[position].alamat)

        Glide.with(holder.itemView).load(listData[position].foto).into(holder.binding.imgMhs)

        holder.binding.item.setOnClickListener {
            var detail = Intent(it.context,DetailActivity::class.java)
            detail.putExtra("id",listData[position].id)
            it.context.startActivity(detail)
        }

        holder.binding.imgEdit.setOnClickListener {
            var edit = Intent(it.context,EditDataActivity::class.java)
            edit.putExtra("id",listData[position].id)
            it.context.startActivity(edit)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}