package uz.revolution.lesson2expandablelistview2_topshiriq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import kotlinx.android.synthetic.main.child_item.view.*
import kotlinx.android.synthetic.main.group_item.view.*
import uz.revolution.lesson2expandablelistview2_topshiriq.models.MyModel

//class ExpandableAdapter(var titleList: List<String>, var map: HashMap<String, ArrayList<MyModel>>) :
//    BaseExpandableListAdapter() {
//
//    private var onChildItemClickListener: OnChildItemClickListener? = null
//
//    override fun getGroup(p0: Int): String {
//        return titleList[p0]
//    }
//
//    override fun getChild(p0: Int, p1: Int): MyModel {
//        val list = map[titleList[p0]]
//        return list!![p1]
//    }
//
//    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
//        return true
//    }
//
//    override fun hasStableIds(): Boolean {
//        return true
//    }
//
//    override fun getGroupCount(): Int {
//        return titleList.size
//    }
//
//    override fun getChildrenCount(p0: Int): Int {
//        return map[titleList[p0]]?.size!!
//    }
//
//    override fun getGroupId(p0: Int): Long {
//        return p0.toLong()
//    }
//
//    override fun getChildId(p0: Int, p1: Int): Long {
//        return p1.toLong()
//    }
//
//    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
//
//        val view = LayoutInflater.from(p3?.context).inflate(R.layout.group_item, p3, false)
//
//        view.titles.text = titleList[p0]
//
//
//        return view
//    }
//
//    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
//
//        val view = LayoutInflater.from(p4?.context).inflate(R.layout.child_item, null, false)
//
//        val list = map[titleList[p0]]
//        val get = list!![p0]
//
//        view.title_child.text = get.name
//
//        view.setOnClickListener {
//            if (onChildItemClickListener != null) {
//                onChildItemClickListener?.onClick(get.info)
//            }
//        }
//
//        return view
//    }
//
//    interface OnChildItemClickListener {
//        fun onClick(info: String)
//    }
//
//    fun setOnChildItemClickListener(onChildItemClickListener: OnChildItemClickListener) {
//        this.onChildItemClickListener = onChildItemClickListener
//    }
//}

class ExpandableAdapter(var titleList: List<String>,var map: HashMap<String,ArrayList<MyModel>>)
    :BaseExpandableListAdapter() {

    private var onChildItemClickListener: OnChildItemClickListener?=null

    override fun getGroup(groupPosition: Int): String {
        return titleList[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, p1: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getChildrenCount(p0: Int): Int {
        return map[titleList[p0]]?.size!!
    }

    override fun getChild(groupPosition: Int, p1: Int): MyModel {
        val list = map[titleList[groupPosition]]
        return list!![p1]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getGroupView(groupPosition: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val view=LayoutInflater.from(p3?.context).inflate(R.layout.group_item,p3,false)

        view.titles.text=titleList[groupPosition]

        return view
    }

    override fun getChildView(groupPosition: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {

        val view = LayoutInflater.from(p4?.context).inflate(R.layout.child_item, p4, false)
        val list = map[titleList[groupPosition]]

        val get = list!![p1]

        view.title_child.text=get.name

        view.setOnClickListener(View.OnClickListener {
            if (onChildItemClickListener != null) {
                onChildItemClickListener?.onClick(get.name,get.info)
            }
        })

        return view
    }

    interface OnChildItemClickListener{
        fun onClick(name:String,info:String)
    }

    fun setOnChildItemClickListener(onChildItemClickListener: OnChildItemClickListener) {
        this.onChildItemClickListener=onChildItemClickListener
    }
}
