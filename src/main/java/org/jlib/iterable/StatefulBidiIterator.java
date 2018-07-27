/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2018 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.iterable;

public final class StatefulBidiIterator<Item, Itble extends Iterable<Item>, State extends BidiIteratorState<Item,
    State>>
    extends StatefulIterator<Item, Itble, State>
    implements BidiIterator<Item> {

    public StatefulBidiIterator(final Itble iterable, final State initialState) {
        super(iterable, initialState);
    }

    @Override
    public final boolean hasPrevious() {
        return getCurrentState().hasPrevious();
    }

    @Override
    public final Item previous()
        throws NoNextItemException {
        final Item previousItem = getCurrentState().next();

        setCurrentState(getCurrentState().nextState());

        return previousItem;
    }
}