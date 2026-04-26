package com.slicedwork.data.repository.fake

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.model.JobAddress
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.model.JobStatus

internal object FakeJobCatalog {
    val jobs: List<Job> =
        listOf(
            Job(
                id = "1",
                ownerId = "user_1",
                title = "Preciso de ajuda para limpar o quintal",
                description = "Quero alguém para varrer folhas, recolher galhos e organizar o quintal.",
                category = JobCategory.CLEANING,
                address =
                    JobAddress(
                        country = "Brasil",
                        state = "SP",
                        city = "Campinas",
                        neighborhood = "Centro",
                        postalCode = "13000-000",
                        street = "Rua das Flores",
                        number = "123",
                        complement = null,
                    ),
                imageUrl = null,
                price = 25.50,
                status = JobStatus.OPEN,
            ),
            Job(
                id = "2",
                ownerId = "user_2",
                title = "Trocar resistência do chuveiro",
                description = "Preciso de alguém para verificar o chuveiro e trocar a resistência ainda esta semana.",
                category = JobCategory.PLUMBING,
                address =
                    JobAddress(
                        country = "Brasil",
                        state = "SP",
                        city = "Campinas",
                        neighborhood = "Taquaral",
                        postalCode = "13000-111",
                        street = "Av. Principal",
                        number = "456",
                        complement = "Casa 2",
                    ),
                imageUrl = "https://picsum.photos/300/200",
                price = 0.49,
                status = JobStatus.OPEN,
            ),
            Job(
                id = "3",
                ownerId = "user_3",
                title = "Cortar a grama e podar plantas da frente da casa",
                description =
                    "Preciso de ajuda para aparar a grama e organizar as plantas do " +
                        "jardim da frente. O serviço pode ser feito no sábado de manhã.",
                category = JobCategory.GARDENING,
                address =
                    JobAddress(
                        country = "Brasil",
                        state = "SP",
                        city = "Campinas",
                        neighborhood = "Barão Geraldo",
                        postalCode = "13000-222",
                        street = "Rua do Bosque",
                        number = "78",
                        complement = null,
                    ),
                imageUrl = null,
                price = 100.80,
                status = JobStatus.OPEN,
            ),
        )
}
