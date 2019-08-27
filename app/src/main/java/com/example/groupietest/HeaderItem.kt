package com.example.groupietest

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.header.view.*

class HeaderItem(private val identifier: Long, private val section: Section) : Item(), ExpandableItem {

    private lateinit var expandableGroup: ExpandableGroup

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }

    override fun getId(): Long = identifier

    override fun getLayout(): Int = R.layout.header

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.containerView) {
            header_text.text = identifier.toString()
            setOnClickListener {
                expandableGroup.onToggleExpanded()
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HeaderItem) return false

        if (identifier != other.identifier) return false
        if (expandableGroup.itemCount != other.expandableGroup.itemCount) return false
        return true
    }

    override fun hashCode(): Int {
        var result = identifier.hashCode()
        result = 31 * result + expandableGroup.hashCode()
        return result
    }
}