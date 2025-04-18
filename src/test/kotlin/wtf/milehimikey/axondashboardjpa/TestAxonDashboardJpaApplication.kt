package wtf.milehimikey.axondashboardjpa

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<AxonDashboardJpaApplication>().with(TestcontainersConfiguration::class).run(*args)
}
