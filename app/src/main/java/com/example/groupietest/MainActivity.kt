package com.example.groupietest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val section = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = GroupAdapter<ViewHolder>()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
        val expandableGroups = listOf(
            ExpandableGroup(
                HeaderItem(1, section)
            ).apply { addAll(listOf(addChildItem(2), addChildItem(3))) },
            ExpandableGroup(
                HeaderItem(4, section)
            ).apply { addAll(listOf(addChildItem(5), addChildItem(6))) },
            ExpandableGroup(
                HeaderItem(7, section)
            ).apply { addAll(listOf(addChildItem(8), addChildItem(9))) },
            ExpandableGroup(
                HeaderItem(10, section)
            ).apply { addAll(listOf(addChildItem(11), addChildItem(12))) },
            ExpandableGroup(
                HeaderItem(13, section)
            ).apply { addAll(listOf(addChildItem(14), addChildItem(15))) },
            ExpandableGroup(
                HeaderItem(16, section)
            ).apply { addAll(listOf(addChildItem(17), addChildItem(18))) }
        )
        section.update(expandableGroups)
        adapter.update(listOf(section))
    }

    fun update() {
        val expandableGroups = listOf(
            ExpandableGroup(
                HeaderItem(1, section)
            ).apply { addAll(listOf(addChildItem(2), addChildItem(3))) },
            ExpandableGroup(
                HeaderItem(4, section)
            ).apply { addAll(listOf(addChildItem(5), addChildItem(6))) },
            ExpandableGroup(
                HeaderItem(7, section)
            ).apply { addAll(listOf(addChildItem(8), addChildItem(9))) },
            ExpandableGroup(
                HeaderItem(10, section)
            ).apply { addAll(listOf(addChildItem(11), addChildItem(12))) },
            ExpandableGroup(
                HeaderItem(13, section)
            ).apply { addAll(listOf(addChildItem(14), addChildItem(15))) },
            ExpandableGroup(
                HeaderItem(16, section)
            ).apply { addAll(listOf(addChildItem(17), addChildItem(18))) }
        )
        section.update(expandableGroups)
    }

    private fun addChildItem(identifier: Long) = ChildItem(identifier) { update() }
}
