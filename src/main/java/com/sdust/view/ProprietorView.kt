package com.sdust.view

import com.sdust.dao.PropertorDao
import com.sdust.model.Propertor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * 业主管理视图
 * Created by zhangzhengkun on 2017/6/4.
 */

@Component
open class ProprietorView(
        @Autowired val propertorDao: PropertorDao) {

    fun printMenu() {
        println("-----------------------")
        println("1.查看所有业主信息")
        println("2.添加业主")
        println("0.返回主菜单")
        println("-----------------------")
    }

    fun showAll() =
        propertorDao.findAll()?.forEach { println(it) }

    fun add() {
        val cur = Propertor()
        print("输入业主姓名：")
        cur.prName = readLine()
        print("输入业主性别：")
        cur.prSex = readLine()
        print("输入业主手机号：")
        cur.prPhone = readLine()
        print("输入业主身份证号：")
        cur.prIdNumber = readLine()
        try {
            propertorDao.add(cur)
        } catch (e: Exception) {
            System.err.println("添加新用户失败")
            System.err.println(e.message)
        }
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