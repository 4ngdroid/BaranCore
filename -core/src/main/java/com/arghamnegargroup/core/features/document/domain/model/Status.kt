package com.arghamnegargroup.core.features.document.domain.model

/**
 * Draft. For a document you created and then saved without sending.
 * Sent. The email notification has been sent to at least one recipient. The document remains in this state until all recipients have viewed the document. (Shown in Reports and History only).
 * Voided. The sender canceled the document before it was completed.
 * Completed. A document is completed once all of the recipients have completed their actions.
 */
enum class Status {
    Draft, Sent, Voided, Completed, Failed
}