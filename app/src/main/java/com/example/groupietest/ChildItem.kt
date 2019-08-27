package com.example.groupietest

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item.view.*

data class ChildItem(private val identifier: Long, private val onClick: () -> Unit) : Item() {

    private var clicker = 0
    override fun getId(): Long = identifier

    override fun getLayout(): Int = R.layout.item

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.containerView) {
            setOnClickListener {
                item_text.text = clicker.toString()
                clicker++
                onClick.invoke()
            }
            item_text.text = identifier.toString()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChildItem) return false

        if (identifier != other.identifier) return false

        return true
    }

    override fun hashCode(): Int {
        return identifier.hashCode()
    }
}