package com.acaroom.recyclerviewpet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_list_item.*

class ExtensionDataAdapter(
    val items: ArrayList<Pet>,
    val context: Context,
    val itemSelect: (Pet) -> Unit  // ② 클릭 이벤트를 처리하기 위한 람다식 함수(핸들러)

) : RecyclerView.Adapter<ExtensionDataAdapter.ExtensionViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtensionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.data_list_item,
            parent,
            false
        )
        return ExtensionViewHolder(view, itemSelect)

    }

    override fun onBindViewHolder(holder: ExtensionViewHolder, position: Int) {
        holder.bind(items[position], context)
    }

    // ③ 이너 클래스로 사용자 뷰홀더 클래스를 지정
    inner class ExtensionViewHolder(override val containerView: View, itemSelect: (Pet) -> Unit)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(pet: Pet, context: Context) {  // ⑤ 데이터를 연결
            if (pet.photo != "") {  // 애완동물 이미지
                val resourceId = context.resources.getIdentifier(
                    pet.photo,
                    "drawable",
                    context.packageName
                )
                img_pet?.setImageResource(resourceId)
            } else {  // 없으면 기본 아이콘으로
                img_pet?.setImageResource(R.mipmap.ic_launcher)
            }
            // findViewById 없이 리소스명 사용
            tv_breed.text = pet.breed
            tv_age.text = pet.age
            tv_gender.text = pet.gender

            //  ④ 항목이 클릭되면 itemSelect 람다식 함수가 처리
            itemView.setOnClickListener() { itemSelect(pet) }

        }
    }
}
