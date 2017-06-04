package com.sdust.view

import com.sdust.dao.HouseDao
import com.sdust.model.House
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * 楼盘管理
 * Created by zhangzhengkun on 2017/6/4.
 */

@Component
open class HouseView(
        @Autowired val houseDao: HouseDao) {

    fun printMenu() {
        println("-----------------------")
        println("1.查看所有房产信息")
        println("2.添加房产")
        println("0.返回主菜单")
        println("-----------------------")
    }

    fun add() {
        try {
            val cur = House()
            print("请输入楼号：")
            cur.buildingNo = readLine()?.toInt()!!
            print("请输入单元号：")
            cur.unitNo = readLine()?.toInt()!!
            print("请输入房间号：")
            cur.houseNo = readLine()?.toInt()!!
            print("请输入业主编号：")
            cur.prpertorId = readLine()?.toInt()!!
            print("请输入销售状态(未售/已售)：")
            cur.sealState = readLine()
            print("请输入房屋类型(?室?厅)：")
            cur.houseStyle = readLine()
            print("请输入房屋面积(平米)：")
            cur.houseArea = readLine()?.toDouble()!!
            houseDao.addHouse(cur)
            println("添加新房产信息成功！")
        } catch (e: Exception) {
            System.err.println("添加新房产信息失败")
            System.err.println(e.message)
        }
    }

    fun showAll() {
        houseDao.allHouse()?.forEach { println(it) }
    }

    fun run() {
        while (true) {
            printMenu()
            val num = readLine()?.trim()?.toInt()
            when (num) {
                1 -> showAll()
                2 -> add()
                0 -> return
            }
        }
    }

}