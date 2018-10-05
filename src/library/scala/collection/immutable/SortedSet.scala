/*
 * Scala (https://www.scala-lang.org)
 *
 * Copyright EPFL and Lightbend, Inc.
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package scala
package collection
package immutable

import generic._

/** A subtrait of `collection.SortedSet` which represents sorted sets
 *  which cannot be mutated.
 *
 *  @author Sean McDirmid
 *  @author Martin Odersky
 *  @since   2.4
 *  @define Coll `immutable.SortedSet`
 *  @define coll immutable sorted set
 */
trait SortedSet[A] extends Set[A] with scala.collection.SortedSet[A] with SortedSetLike[A, SortedSet[A]] {
  /** Needs to be overridden in subclasses. */
  override def empty: SortedSet[A] = SortedSet.empty[A]
}

/** $factoryInfo
 *  @define Coll `immutable.SortedSet`
 *  @define coll immutable sorted set
 */
object SortedSet extends ImmutableSortedSetFactory[SortedSet] {
  /** $sortedSetCanBuildFromInfo */
  def canBuildFrom[A](implicit ord: Ordering[A]): CanBuildFrom[Coll, A, SortedSet[A]] = newCanBuildFrom[A]
  def empty[A](implicit ord: Ordering[A]): SortedSet[A] = TreeSet.empty[A]
  // Force a declaration here so that BitSet (which does not inherit from SortedSetFactory) can be more specific
  override implicit def newCanBuildFrom[A](implicit ord : Ordering[A]) : CanBuildFrom[Coll, A, SortedSet[A]] = super.newCanBuildFrom
}
