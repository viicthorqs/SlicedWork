package com.slicedwork.jobdetails.ui.preview

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.model.JobAddress
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.model.JobStatus

object JobDetailsPreviewData {

    val job = Job(
        id = "preview-1",
        ownerId = "preview_user",
        title = "Pintar sala de estar (2 paredes)",
        description = "Preciso de alguém para pintar duas paredes da sala de estar. As paredes estão em bom estado, " +
                "sem infiltração ou grandes reparos, mas podem precisar de uma preparação simples antes da pintura. " +
                "A tinta já será fornecida pelo contratante. O ideal é que a pessoa tenha experiência com pintura residencial, " +
                "cuidado com móveis e piso, e consiga deixar o ambiente limpo ao finalizar o serviço.",
        category = JobCategory.PAINTING,
        address = JobAddress(
            country = "Brasil",
            state = "SP",
            city = "Campinas",
            neighborhood = "Cambuí",
            postalCode = "13000-000",
            street = "Rua Preview",
            number = "10",
            complement = null,
        ),
        imageUrl = null,
        price = 350.0,
        status = JobStatus.OPEN,
    )
}
