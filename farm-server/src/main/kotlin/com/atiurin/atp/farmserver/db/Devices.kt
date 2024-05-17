package com.atiurin.atp.farmserver.db

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Devices : Table() {
    val uid: Column<String> = varchar("uid", 50).uniqueIndex()
    val name: Column<String> = varchar("name", 50)
    val groupId: Column<String> = varchar("groupId", 50)
    val ip: Column<String> = varchar("ip", 50)
    val adbPort: Column<Int> = integer("adbPort")
    val grpcPort: Column<Int?> = integer("grpcPort").nullable()
    val dockerImage: Column<String> = varchar("dockerImage", length = 200)
    val userAgent: Column<String?> = varchar("userAgent", length = 1000).nullable().default(null)
    val desc: Column<String?> = varchar("desc", length = 1000).nullable()
    val busyTimestamp: Column<Long> = long("busyTimestamp").default(0L)
    val lastPingTimestamp: Column<Long> = long("lastPingTimestamp").default(0L)
    val state: Column<String> = varchar("state",50)
    val status: Column<String> = varchar("status",50)
}