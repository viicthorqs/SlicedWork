package com.slicedwork.home.ui.preview

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.model.JobAddress
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.model.JobStatus

/**
 * Dados só para previews Compose (`@Preview`) no módulo home.
 * Não precisa espelhar `FakeJobCatalog` no módulo data — duplicação intencional.
 */
object HomeJobPreviewData {

    val jobs: List<Job> = listOf(
        Job(
            id = "preview-1",
            ownerId = "preview_user",
            title = "Pintar sala de estar (2 paredes)",
            description = "Preview — descrição curta.",
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
        ),
        Job(
            id = "preview-2",
            ownerId = "preview_user",
            title = "Instalar três tomadas na cozinha",
            description = "Preview — elétrica.",
            category = JobCategory.ELECTRIC,
            address = JobAddress(
                country = "Brasil",
                state = "SP",
                city = "Campinas",
                neighborhood = "Nova Campinas",
                postalCode = "13000-001",
                street = "Av. Exemplo",
                number = "200",
                complement = "Apto 12",
            ),
            imageUrl = null,
            price = 120.0,
            status = JobStatus.OPEN,
        ),
    )
}
