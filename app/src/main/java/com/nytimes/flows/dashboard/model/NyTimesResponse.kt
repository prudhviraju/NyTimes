package com.nytimes.flows.dashboard.model

data class NyTimesResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)

data class Result(
    val abstract: String,
    val adx_keywords: String,
    val asset_id: Long,
    val byline: String,
    val column: Any,
    val id: Long,
    val media: List<Media>,
    val published_date: String,
    val section: String,
    val source: String,
    val title: String,
    val type: String,
    val url: String,
    val views: Int
)

data class Media(
    val approved_for_syndication: Int,
    val caption: String,
    val copyright: String,
    //val media-metadata : List<MediaMetadata>,
    val subtype: String,
    val type: String
)

data class MediaMetadata(
    val format: String,
    val height: Int,
    val url: String,
    val width: Int
)