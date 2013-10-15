/*  DriftingDroids - yet another Ricochet Robots solver program.
    Copyright (C) 2011, 2012, 2013  Michael Henke

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package driftingdroids.model;

/**
 * This interface specifies a specialized <code>Map</code> that is used
 * by the IDDFS solver. Its purpose is to store board positions together
 * with the corresponding search depths (number of moves to reach the positions)
 * and to detect duplicates, that is whether a position has already been found
 * at a lower search depth.<p>
 * The IDDFS solver uses this information to speed up the search by skipping
 * duplicate branches of the search tree.
 */
public interface KeyDepthMap {

    /**
     * Associates the specified <code>unsigned byte</code> value with the specified
     * <code>int</code> key in this map.
     * If the map previously contained a mapping for the key, the specified value
     * replaces the old value only if it's greater than the old value.
     *  
     * @param key - key with which the specified value is to be associated; must be
     * generated by <code>KeyMakerInt</code>.
     * @param byteValue - unsigned byte value (0...255) to be associated with the specified key
     * @return true if the specified value was placed in this map. false if the map already contained
     * for this key a value that is greater than or equal to the specified value.
     */
    public boolean putIfGreater(int key, int byteValue);

    /**
     * Associates the specified <code>unsigned byte</code> value with the specified
     * <code>long</code> key in this map.
     * If the map previously contained a mapping for the key, the specified value
     * replaces the old value only if it's greater than the old value.
     *  
     * @param key - key with which the specified value is to be associated; must be
     * generated by <code>KeyMakerLong</code>.
     * @param byteValue - unsigned byte value (0...255) to be associated with the specified key
     * @return true if the specified value was placed in this map. false if the map already contained
     * for this key a value that is greater than or equal to the specified value.
     */
    public boolean putIfGreater(long key, int byteValue);

    /**
     * Returns the number of elements (key/value pairs) currently stored in this map.
     * This is for information only; some implementations may return a wrong value.
     * 
     * @return number of elements in this map
     */
    public int size();

    /**
     * Returns the number of bytes that are allocated by this map's internal data structures.
     * This is for information only; some implementations may return a wrong value.
     * 
     * @return number of bytes allocated by this map (approximate)
     */
    public long allocatedBytes();

}