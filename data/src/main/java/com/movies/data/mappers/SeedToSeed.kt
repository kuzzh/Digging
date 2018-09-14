package com.movies.data.mappers

import com.movies.dytt.entities.Seed
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/14.
 * @description
 * @version
 */
@Singleton
class SeedToSeed @Inject constructor() : Mapper<Seed, Seed> {
    override fun map(from: Seed) = from
}