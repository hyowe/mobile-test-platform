package com.atiurin.atp.farmserver.pool

import com.atiurin.atp.farmserver.db.DataSource
import com.atiurin.atp.farmserver.device.DeviceRepository
import com.atiurin.atp.farmserver.device.TestContainersDeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Lazy
@Component
class DBTestContainersPool @Autowired constructor(
    @Lazy repository: TestContainersDeviceRepository,
    @Lazy dataSource: DataSource
) : DBDevicePool(dataSource) {
    override val deviceRepository: DeviceRepository = repository

    override fun release(deviceId: String) {
        remove(deviceId)
    }
}