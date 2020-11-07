/*
 * Copyright (C) 2020 Grakn Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package grakn.core.traversal;

import grakn.core.common.iterator.ResourceIterator;
import grakn.core.graph.GraphManager;
import grakn.core.graph.vertex.Vertex;
import graql.lang.pattern.variable.Reference;

import java.util.Map;

public class TraversalEngine {

    private final GraphManager graphMgr;
    private final TraversalCache cache;

    public TraversalEngine(final GraphManager graphMgr, TraversalCache cache) {
        this.graphMgr = graphMgr;
        this.cache = cache;
    }

    public ResourceIterator<Map<Reference, Vertex<?, ?>>> execute(final Traversal traversal) {
        traversal.initialisePlanner(cache);
        return traversal.execute(graphMgr);
    }
}
