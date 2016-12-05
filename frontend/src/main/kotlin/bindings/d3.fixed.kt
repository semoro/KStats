package bindings

import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.DocumentFragment
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventTarget
import org.w3c.xhr.XMLHttpRequest

interface JsArray<T>

@native
object d3 {
    var version: String = noImpl
    fun select(selector: String): Selection<Any> = noImpl
    fun select(node: EventTarget): Selection<Any> = noImpl
    fun selectAll(selector: String): Selection<Any> = noImpl
    fun selectAll(nodes: Array<EventTarget>): Selection<Any> = noImpl
    fun selection(): Selection<Any> = noImpl
    @native
    object selection {
        var prototype: Selection<Any> = noImpl
        interface Group : JsArray<EventTarget> {
            var parentNode: EventTarget
        }
        /// TODO bug
        interface `T$0`<Datum> {
            @nativeGetter
            fun get(key: String): dynamic /* dynamic /* Primitive = number | string | boolean */ | (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Primitive = number | string | boolean */ */
            @nativeSetter
            fun set(key: String, value: dynamic /* Primitive = number | string | boolean */)
            @nativeSetter
            fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Primitive = number | string | boolean */)
        }
        interface `T$1`<Datum> {
            @nativeGetter
            fun get(key: String): dynamic /* Boolean | (datum: Datum, index: Number, outerIndex: Number) -> Boolean */
            @nativeSetter
            fun set(key: String, value: Boolean)
            @nativeSetter
            fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> Boolean)
        }
        interface `T$2`<Datum> {
            @nativeGetter
            fun get(key: String): dynamic /* dynamic /* Primitive = number | string | boolean */ | (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Primitive = number | string | boolean */ */
            @nativeSetter
            fun set(key: String, value: dynamic /* Primitive = number | string | boolean */)
            @nativeSetter
            fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Primitive = number | string | boolean */)
        }
        interface `T$3`<Datum> {
            @nativeGetter
            fun get(key: String): dynamic /* Any | (datum: Datum, index: Number, outerIndex: Number) -> Any */
            @nativeSetter
            fun set(key: String, value: Any)
            @nativeSetter
            fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> Any)
        }
        interface Update<Datum> {
            @nativeGetter
            fun get(index: Number): Group?
            @nativeSetter
            fun set(index: Number, value: Group)
            var length: Number
            fun attr(name: String): String
            fun attr(name: String, value: dynamic /* Primitive = number | string | boolean */): Update<Datum>
            fun attr(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Primitive = number | string | boolean */): Update<Datum>
            fun attr(obj: `T$0`<Datum>): Update<Datum>
            fun classed(name: String): Boolean
            fun classed(name: String, value: Boolean): Update<Datum>
            fun classed(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> Boolean): Update<Datum>
            fun classed(obj: `T$1`<Datum>): Update<Datum>
            fun style(name: String): String
            fun style(name: String, value: dynamic /* Primitive = number | string | boolean */, priority: String? = null): Update<Datum>
            fun style(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Primitive = number | string | boolean */, priority: String? = null): Update<Datum>
            fun style(obj: `T$2`<Datum>, priority: String? = null): Update<Datum>
            fun property(name: String): Any
            fun property(name: String, value: Any): Update<Datum>
            fun property(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> Any): Update<Datum>
            fun property(obj: `T$3`<Datum>): Update<Datum>
            fun text(): String
            fun text(value: dynamic /* Primitive = number | string | boolean */): Update<Datum>
            fun text(value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Primitive = number | string | boolean */): Update<Datum>
            fun html(): String
            fun html(value: String): Selection<Datum>
            fun html(value: (datum: Datum, index: Number, outerIndex: Number) -> String): Selection<Datum>
            fun append(name: String): Selection<Datum>
            fun append(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Update<Datum>
            fun insert(name: String, before: String): Update<Datum>
            fun insert(name: String, before: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Update<Datum>
            fun insert(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget, before: String): Update<Datum>
            fun insert(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget, before: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Update<Datum>
            fun remove(): Update<Datum>
            fun data(): Array<Datum>
            fun <NewDatum> data(data: Array<NewDatum>, key: ((datum: NewDatum, index: Number, outerIndex: Number) -> String)? = null): Update<NewDatum>
            fun <NewDatum> data(data: (datum: Datum, index: Number, outerIndex: Number) -> Array<NewDatum>, key: ((datum: NewDatum, index: Number, outerIndex: Number) -> String)? = null): Update<NewDatum>
            fun filter(selector: String): Update<Datum>
            fun filter(selector: (datum: Datum, index: Number, outerIndex: Number) -> Boolean): Update<Datum>
            fun datum(): Datum
            fun <NewDatum> datum(value: (datum: Datum, index: Number, outerIndex: Number) -> NewDatum): Update<NewDatum>
            fun <NewDatum> datum(value: NewDatum): Update<NewDatum>
            fun sort(comparator: ((a: Datum, b: Datum) -> Number)? = null): Update<Datum>
            fun order(): Update<Datum>
            fun on(type: String): (datum: Datum, index: Number, outerIndex: Number) -> Any
            fun on(type: String, listener: (datum: Datum, index: Number, outerIndex: Number) -> Any, capture: Boolean? = null): Update<Datum>
            fun transition(name: String? = null): Transition<Datum>
            fun interrupt(name: String? = null): Update<Datum>
            fun select(selector: String): Update<Datum>
            fun select(selector: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Update<Datum>
            fun selectAll(selector: String): Update<Datum>
            fun selectAll(selector: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Array<EventTarget> | NodeList */): Update<Any>
            fun each(func: (datum: Datum, index: Number, outerIndex: Number) -> Any): Update<Datum>
            // TODO bug
//            fun call(func: (sel: Update<Datum>, vararg args: Any) -> Any, vararg args: Any): Update<Datum>
            fun empty(): Boolean
            fun node(): Node
            fun size(): Number
            fun enter(): Enter<Datum>
            fun exit(): Selection<Datum>
        }
        interface Enter<Datum> {
            fun append(name: String): Selection<Datum>
            fun append(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
            fun insert(name: String, before: String? = null): Selection<Datum>
            fun insert(name: String, before: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
            fun insert(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget, before: String? = null): Selection<Datum>
            fun insert(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget, before: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
            fun select(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
//            fun call(func: (selection: Enter<Datum>, vararg args: Any) -> Any, vararg args: Any): Enter<Datum>
            fun empty(): Boolean
            fun size(): Number
        }
    }
    interface Numeric {
        fun valueOf(): Number
    }
    interface `T$4`<Datum> {
        @nativeGetter
        fun get(key: String): dynamic /* Number | String | Boolean | (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */ */
        @nativeSetter
        fun set(key: String, value: Number)
        @nativeSetter
        fun set(key: String, value: String)
        @nativeSetter
        fun set(key: String, value: Boolean)
        @nativeSetter
        fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */)
    }
    interface `T$5`<Datum> {
        @nativeGetter
        fun get(key: String): dynamic /* Boolean | (datum: Datum, index: Number, outerIndex: Number) -> Boolean */
        @nativeSetter
        fun set(key: String, value: Boolean)
        @nativeSetter
        fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> Boolean)
    }
    interface `T$6`<Datum> {
        @nativeGetter
        fun get(key: String): dynamic /* Number | String | Boolean | (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */ */
        @nativeSetter
        fun set(key: String, value: Number)
        @nativeSetter
        fun set(key: String, value: String)
        @nativeSetter
        fun set(key: String, value: Boolean)
        @nativeSetter
        fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */)
    }
    interface `T$7`<Datum> {
        @nativeGetter
        fun get(key: String): dynamic /* Any | (datum: Datum, index: Number, innerInder: Number) -> Any */
        @nativeSetter
        fun set(key: String, value: Any)
        @nativeSetter
        fun set(key: String, value: (datum: Datum, index: Number, innerInder: Number) -> Any)
    }
    interface Selection<Datum> {
        @nativeGetter
        fun get(index: Number): selection.Group?
        @nativeSetter
        fun set(index: Number, value: selection.Group)
        var length: Number
        fun attr(name: String): String
        fun attr(name: String, value: Number): Selection<Datum>
        fun attr(name: String, value: String): Selection<Datum>
        fun attr(name: String, value: Boolean): Selection<Datum>
        fun attr(name: String, value: (datum: Datum, index: Int, outerIndex: Int) -> dynamic /* Number | String | Boolean */): Selection<Datum>
        fun attr(name: String, a: d3.svg.Area<*>): Selection<Datum>
        fun attr(obj: `T$4`<Datum>): Selection<Datum>
        fun classed(name: String): Boolean
        fun classed(name: String, value: Boolean): Selection<Datum>
        fun classed(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> Boolean): Selection<Datum>
        fun classed(obj: `T$5`<Datum>): Selection<Datum>
        fun style(name: String): String
        fun style(name: String, value: Number, priority: String? = null): Selection<Datum>
        fun style(name: String, value: String, priority: String? = null): Selection<Datum>
        fun style(name: String, value: Boolean, priority: String? = null): Selection<Datum>
        fun style(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */, priority: String? = null): Selection<Datum>
        fun style(obj: `T$6`<Datum>, priority: String? = null): Selection<Datum>
        fun property(name: String): Any
        fun property(name: String, value: Any): Selection<Datum>
        fun property(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> Any): Selection<Datum>
        fun property(obj: `T$7`<Datum>): Selection<Datum>
        fun text(): String
        fun text(value: Number): Selection<Datum>
        fun text(value: String): Selection<Datum>
        fun text(value: Boolean): Selection<Datum>
        fun text(value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */): Selection<Datum>
        fun html(): String
        fun html(value: String): Selection<Datum>
        fun html(value: (datum: Datum, index: Number, outerIndex: Number) -> String): Selection<Datum>
        fun append(name: String): Selection<Datum>
        fun append(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
        fun insert(name: String, before: String): Selection<Datum>
        fun insert(name: String, before: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
        fun insert(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget, before: String): Selection<Datum>
        fun insert(name: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget, before: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
        fun remove(): Selection<Datum>
        fun data(): Array<Datum>
        fun <NewDatum> data(data: Array<NewDatum>, key: ((datum: NewDatum, index: Number, outerIndex: Number) -> String)? = null): selection.Update<NewDatum>
        fun <NewDatum> data(data: (datum: Datum, index: Number, outerIndex: Number) -> Array<NewDatum>, key: ((datum: NewDatum, index: Number, outerIndex: Number) -> String)? = null): selection.Update<NewDatum>
        fun filter(selector: String): Selection<Datum>
        fun filter(selector: (datum: Datum, index: Number, outerIndex: Number) -> Boolean): Selection<Datum>
        fun datum(): Datum
        fun <NewDatum> datum(value: (datum: Datum, index: Number, outerIndex: Number) -> NewDatum): Selection<NewDatum>
        fun <NewDatum> datum(value: NewDatum): Selection<NewDatum>
        fun sort(comparator: ((a: Datum, b: Datum) -> Number)? = null): Selection<Datum>
        fun order(): Selection<Datum>
        fun on(type: String): (datum: Datum, index: Number, outerIndex: Number) -> Any
        fun on(type: String, listener: Element.(datum: Datum, index: Number, outerIndex: Number) -> Any, capture: Boolean? = null): Selection<Datum>
        fun transition(name: String? = null): Transition<Datum>
        fun interrupt(name: String? = null): Selection<Datum>
        fun select(selector: String): Selection<Datum>
        fun select(selector: (datum: Datum, index: Number, outerIndex: Number) -> EventTarget): Selection<Datum>
        fun selectAll(selector: String): Selection<Any>
        fun <T> selectAll(selector: String): Selection<T>
        fun selectAll(selector: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Array<EventTarget> | NodeList */): Selection<Any>
        fun <T> selectAll(selector: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Array<EventTarget> | NodeList */): Selection<T>
        fun each(func: (datum: Datum, index: Number, outerIndex: Number) -> Any): Selection<Datum>
//        fun call(func: (sel: Selection<Datum>, vararg args: Any) -> Any, vararg args: Any): Selection<Datum>
        fun empty(): Boolean
        fun node(): Node
        fun size(): Number
        fun call(a: d3.svg.Axis): Selection<Datum>
    }
    fun transition(): Transition<Any> = noImpl
    @native
    object transition {
        var prototype: Transition<Any> = noImpl
    }
    interface `T$8`<Datum> {
        @nativeGetter
        fun get(key: String): dynamic /* Number | String | Boolean | (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */ */
        @nativeSetter
        fun set(key: String, value: Number)
        @nativeSetter
        fun set(key: String, value: String)
        @nativeSetter
        fun set(key: String, value: Boolean)
        @nativeSetter
        fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */)
    }
    interface `T$9`<Datum> {
        @nativeGetter
        fun get(key: String): dynamic /* Number | String | Boolean | (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */ */
        @nativeSetter
        fun set(key: String, value: Number)
        @nativeSetter
        fun set(key: String, value: String)
        @nativeSetter
        fun set(key: String, value: Boolean)
        @nativeSetter
        fun set(key: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */)
    }
    interface Transition<Datum> {
        fun transition(): Transition<Datum>
        fun delay(): Number
        fun delay(delay: Number): Transition<Datum>
        fun delay(delay: (datum: Datum, index: Number, outerIndex: Number) -> Number): Transition<Datum>
        fun duration(): Number
        fun duration(duration: Number): Transition<Datum>
        fun duration(duration: (datum: Datum, index: Number, outerIndex: Number) -> Number): Transition<Datum>
        fun ease(): (t: Number) -> Number
        fun ease(value: String, vararg args: Any): Transition<Datum>
        fun ease(value: (t: Number) -> Number): Transition<Datum>
        fun attr(name: String, value: Number): Transition<Datum>
        fun attr(name: String, value: String): Transition<Datum>
        fun attr(name: String, value: Boolean): Transition<Datum>
        fun attr(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */): Transition<Datum>
        fun attr(obj: `T$8`<Datum>): Transition<Datum>
        fun attrTween(name: String, tween: (datum: Datum, index: Number, attr: String) -> (t: Number) -> dynamic /* Number | String | Boolean */): Transition<Datum>
        fun style(name: String, value: Number, priority: String? = null): Transition<Datum>
        fun style(name: String, value: String, priority: String? = null): Transition<Datum>
        fun style(name: String, value: Boolean, priority: String? = null): Transition<Datum>
        fun style(name: String, value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */, priority: String? = null): Transition<Datum>
        fun style(obj: `T$9`<Datum>, priority: String? = null): Transition<Datum>
        fun styleTween(name: String, tween: (datum: Datum, index: Number, attr: String) -> (t: Number) -> dynamic /* Number | String | Boolean */, priority: String? = null): Transition<Datum>
        fun text(value: Number): Transition<Datum>
        fun text(value: String): Transition<Datum>
        fun text(value: Boolean): Transition<Datum>
        fun text(value: (datum: Datum, index: Number, outerIndex: Number) -> dynamic /* Number | String | Boolean */): Transition<Datum>
        fun tween(name: String, factory: () -> (t: Number) -> Any): Transition<Datum>
        fun remove(): Transition<Datum>
        fun select(selector: String): Transition<Datum>
        fun select(selector: (d: Datum, i: Number) -> EventTarget): Transition<Datum>
        fun selectAll(selector: String): Transition<Any>
        fun selectAll(selector: (d: Datum, i: Number) -> Array<EventTarget>): Transition<Any>
        fun filter(selector: String): Transition<Datum>
        fun filter(selector: (d: Datum, i: Number) -> Boolean): Transition<Datum>
        fun each(type: String, listener: (d: Datum, i: Number) -> Any): Transition<Datum>
        fun each(listener: (d: Datum, i: Number) -> Any): Transition<Datum>
//        fun call(func: (transition: Transition<Datum>, vararg args: Any) -> Any, vararg args: Any): Transition<Datum>
        fun empty(): Boolean
        fun node(): Node
        fun size(): Number
    }
//    fun ease(type: Any /* "linear" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "linear-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "linear-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "linear-in-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "linear-out-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "poly" */, k: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "poly-in" */, k: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "poly-out" */, k: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "poly-in-out" */, k: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "poly-out-in" */, k: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "quad" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "quad-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "quad-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "quad-in-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "quad-out-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "cubic" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "cubic-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "cubic-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "cubic-in-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "cubic-out-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "sin" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "sin-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "sin-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "sin-in-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "sin-out-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "circle" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "circle-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "circle-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "circle-in-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "circle-out-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "elastic" */, a: Number? = null, b: Number? = null): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "elastic-in" */, a: Number? = null, b: Number? = null): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "elastic-out" */, a: Number? = null, b: Number? = null): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "elastic-in-out" */, a: Number? = null, b: Number? = null): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "elastic-out-in" */, a: Number? = null, b: Number? = null): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "back" */, s: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "back-in" */, s: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "back-out" */, s: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "back-in-out" */, s: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "back-out-in" */, s: Number): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "bounce" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "bounce-in" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "bounce-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "bounce-in-out" */): (t: Number) -> Number = noImpl
//    fun ease(type: Any /* "bounce-out-in" */): (t: Number) -> Number = noImpl
    fun ease(type: String, vararg args: Any): (t: Number) -> Number = noImpl
    fun timer(func: () -> Any, delay: Number? = null, time: Number? = null): Unit = noImpl
    @native
    object timer {
        fun flush(): Unit = noImpl
    }
    interface BaseEvent {
        var type: String
        var sourceEvent: Event? get() = noImpl; set(value){}
    }
    interface ZoomEvent : BaseEvent {
        var scale: Number
        var translate: Pair<Number, Number>
    }
    interface DragEvent : BaseEvent {
        var x: Number
        var y: Number
        var dx: Number
        var dy: Number
    }
    var event: dynamic /* Event | BaseEvent */ = noImpl
    fun mouse(container: EventTarget): Array<Number> = noImpl
    fun touch(container: EventTarget, identifer: Number): Pair<Number, Number> = noImpl
    fun touch(container: EventTarget, touches: TouchList, identifer: Number): Pair<Number, Number> = noImpl
    fun touches(container: EventTarget, touches: TouchList? = null): Array<Pair<Number, Number>> = noImpl
    fun ascending(a: Number, b: Number): Number = noImpl
    fun ascending(a: Number, b: String): Number = noImpl
    fun ascending(a: Number, b: Boolean): Number = noImpl
    fun ascending(a: String, b: Number): Number = noImpl
    fun ascending(a: String, b: String): Number = noImpl
    fun ascending(a: String, b: Boolean): Number = noImpl
    fun ascending(a: Boolean, b: Number): Number = noImpl
    fun ascending(a: Boolean, b: String): Number = noImpl
    fun ascending(a: Boolean, b: Boolean): Number = noImpl
    fun descending(a: Number, b: Number): Number = noImpl
    fun descending(a: Number, b: String): Number = noImpl
    fun descending(a: Number, b: Boolean): Number = noImpl
    fun descending(a: String, b: Number): Number = noImpl
    fun descending(a: String, b: String): Number = noImpl
    fun descending(a: String, b: Boolean): Number = noImpl
    fun descending(a: Boolean, b: Number): Number = noImpl
    fun descending(a: Boolean, b: String): Number = noImpl
    fun descending(a: Boolean, b: Boolean): Number = noImpl
    fun min(array: Array<Number>): Number = noImpl
    fun min(array: Array<String>): String = noImpl
    fun <T : Numeric> min(array: Array<T>): T = noImpl
    fun <T> min(array: Array<T>, accessor: (datum: T, index: Number) -> Number): Number = noImpl
    fun <T> min(array: Array<T>, accessor: (datum: T, index: Number) -> String): String = noImpl
    fun <T, U : Numeric> min(array: Array<T>, accessor: (datum: T, index: Number) -> U): U = noImpl
    fun max(array: Array<Number>): Number = noImpl
    fun max(array: Array<String>): String = noImpl
    fun <T : Numeric> max(array: Array<T>): T = noImpl
    fun <T> max(array: Array<T>, accessor: (datum: T, index: Number) -> Number): Number = noImpl
//    fun <T> max(array: Array<T>, accessor: (datum: T, index: Number) -> String): String = noImpl
//    fun <T, U : Numeric> max(array: Array<T>, accessor: (datum: T, index: Number) -> U): U = noImpl
    fun extent(array: Array<Number>): Pair<Number, Number> = noImpl
    fun extent(array: Array<String>): Pair<String, String> = noImpl
    //TODO bug
//    fun <T : Numeric> extent(array: Array<T>): Pair<T, T> = noImpl
//    fun <T : Numeric> extent(array: Array<dynamic /* T | Number | String | Boolean */>): Pair<dynamic /* T | Number | String | Boolean */, dynamic /* T | Number | String | Boolean */> = noImpl
//    fun <T> extent(array: Array<T>, accessor: (datum: T, index: Number) -> Number): Pair<Number, Number> = noImpl
//    fun <T> extent(array: Array<T>, accessor: (datum: T, index: Number) -> String): Pair<String, String> = noImpl
    fun <T> extent(array: Array<T>, accessor: (datum: T, index: Number) -> Date): Array<Date> = noImpl
//    fun <T, U : Numeric> extent(array: Array<T>, accessor: (datum: T, index: Number) -> U): Pair<dynamic /* U | Number | String | Boolean */, dynamic /* U | Number | String | Boolean */> = noImpl
    fun sum(array: Array<Number>): Number = noImpl
    fun <T> sum(array: Array<T>, accessor: (datum: T, index: Number) -> Number): Number = noImpl
    fun mean(array: Array<Number>): Number = noImpl
    fun <T> mean(array: Array<T>, accessor: (datum: T, index: Number) -> Number): Number = noImpl
    fun median(array: Array<Number>): Number = noImpl
    fun <T> median(datum: Array<T>, accessor: (datum: T, index: Number) -> Number): Number = noImpl
    fun quantile(array: Array<Number>, p: Number): Number = noImpl
    fun variance(array: Array<Number>): Number = noImpl
    fun <T> variance(array: Array<T>, accessor: (datum: T, index: Number) -> Number): Number = noImpl
    fun deviation(array: Array<Number>): Number = noImpl
    fun <T> deviation(array: Array<T>, accessor: (datum: T, index: Number) -> Number): Number = noImpl
    fun <T> bisectLeft(array: Array<T>, x: T, lo: Number? = null, hi: Number? = null): Number = noImpl
    fun <T> bisect(array: Array<T>, x: T, lo: Number? = null, hi: Number? = null): Number = noImpl
    fun <T> bisectRight(array: Array<T>, x: T, lo: Number? = null, hi: Number? = null): Number = noImpl
    interface `T$10`<T, U> {
        /// TODO bug
//        var left: (array: Array<T>, x: U, lo: Number? = null, hi: Number? = null) -> Number
//        var right: (array: Array<T>, x: U, lo: Number? = null, hi: Number? = null) -> Number
    }
    fun <T, U> bisector(accessor: (x: T) -> U): `T$10`<T, U> = noImpl
    interface `T$11`<T, U> {
//        var left: (array: Array<T>, x: U, lo: Number? = null, hi: Number? = null) -> Number
//        var right: (array: Array<T>, x: U, lo: Number? = null, hi: Number? = null) -> Number
    }
    fun <T, U> bisector(comparator: (a: T, b: U) -> Number): `T$11`<T, U> = noImpl
    fun <T> shuffle(array: Array<T>, lo: Number? = null, hi: Number? = null): Array<T> = noImpl
    fun keys(`object`: Any): Array<String> = noImpl
    interface `T$12`<T> {
        @nativeGetter
        fun get(key: String): T?
        @nativeSetter
        fun set(key: String, value: T)
    }
    fun <T> values(`object`: `T$12`<T>): Array<T> = noImpl
    interface `T$13`<T> {
        @nativeGetter
        fun get(key: Number): T?
        @nativeSetter
        fun set(key: Number, value: T)
    }
    fun <T> values(`object`: `T$13`<T>): Array<T> = noImpl
    /// TODO bug
    fun values(`object`: Any): Array<Any> = noImpl
    interface `T$14`<T> {
        @nativeGetter
        fun get(key: String): T?
        @nativeSetter
        fun set(key: String, value: T)
    }
    interface `T$15`<T> {
        var key: String
        var value: T
    }
    fun <T> entries(`object`: `T$14`<T>): Array<`T$15`<T>> = noImpl
    interface `T$16`<T> {
        @nativeGetter
        fun get(key: Number): T?
        @nativeSetter
        fun set(key: Number, value: T)
    }
    interface `T$17`<T> {
        var key: String
        var value: T
    }
    fun <T> entries(`object`: `T$16`<T>): Array<`T$17`<T>> = noImpl
    interface `T$18` {
        var key: String
        var value: Any
    }
    fun entries(`object`: Any): Array<`T$18`> = noImpl
    interface `T$19`<T> {
        var key: String
        var value: T
    }
    interface Map<T> {
        fun has(key: String): Boolean
        fun get(key: String): T
        fun set(key: String, value: T): T
        fun remove(key: String): Boolean
        fun keys(): Array<String>
        fun values(): Array<T>
        fun entries(): Array<`T$19`<T>>
        fun forEach(func: (key: String, value: T) -> Any)
        fun empty(): Boolean
        fun size(): Number
    }
    fun <T> map(): Map<T> = noImpl
    fun <T> map(`object`: Map<T>): Map<T> = noImpl
    interface `T$20`<T> {
        @nativeGetter
        fun get(key: String): T?
        @nativeSetter
        fun set(key: String, value: T)
    }
    fun <T> map(`object`: `T$20`<T>): Map<T> = noImpl
    interface `T$21`<T> {
        @nativeGetter
        fun get(key: Number): T?
        @nativeSetter
        fun set(key: Number, value: T)
    }
    fun <T> map(`object`: `T$21`<T>): Map<T> = noImpl
    fun <T> map(array: Array<T>, key: (datum: T, index: Number) -> String): Map<T> = noImpl
    fun map(`object`: Any): Map<Any> = noImpl
    interface Set {
        fun has(value: String): Boolean
        fun add(value: String): String
        fun remove(value: String): Boolean
        fun values(): Array<String>
        fun forEach(func: (value: String) -> Any)
        fun empty(): Boolean
        fun size(): Number
    }
    fun set(): Set = noImpl
    fun set(array: Array<String>): Set = noImpl
    fun <T> merge(arrays: Array<Array<T>>): Array<T> = noImpl
    fun range(stop: Number): Array<Number> = noImpl
    fun range(start: Number, stop: Number, step: Number? = null): Array<Number> = noImpl
    interface `T$22`<T> {
        @nativeGetter
        fun get(key: Number): T?
        @nativeSetter
        fun set(key: Number, value: T)
    }
    fun <T> permute(array: `T$22`<T>, keys: Array<Number>): Array<T> = noImpl
    interface `T$23`<T> {
        @nativeGetter
        fun get(key: String): T?
        @nativeSetter
        fun set(key: String, value: T)
    }
    fun <T> permute(`object`: `T$23`<T>, keys: Array<String>): Array<T> = noImpl
    fun <T> zip(vararg arrays: Array<T>): Array<Array<T>> = noImpl
    fun <T> transpose(matrix: Array<Array<T>>): Array<Array<T>> = noImpl
    fun <T> pairs(array: Array<T>): Array<Pair<T, T>> = noImpl
    interface `T$24` {
        var key: String
        var values: Any
    }
    interface Nest<T> {
        fun key(func: (datum: T) -> String): Nest<T>
        fun sortKeys(comparator: (a: String, b: String) -> Number): Nest<T>
        fun sortValues(comparator: (a: T, b: T) -> Number): Nest<T>
        fun <U> rollup(func: (values: Array<T>) -> U): Nest<T>
        fun map(array: Array<T>): Json
        fun map(array: Array<T>, mapType: Map<Any>): Map<Any>
        fun entries(array: Array<T>): Array<`T$24`>
    }
    fun <T> nest(): Nest<T> = noImpl
    @native
    object random {
        fun normal(mean: Number? = null, deviation: Number? = null): () -> Number = noImpl
        fun logNormal(mean: Number? = null, deviation: Number? = null): () -> Number = noImpl
        fun bates(count: Number): () -> Number = noImpl
        fun irwinHall(count: Number): () -> Number = noImpl
    }
    interface Transform {
        var rotate: Number
        var translate: Pair<Number, Number>
        var skew: Number
        var scale: Pair<Number, Number>
        override fun toString(): String
    }
    fun transform(transform: String): Transform = noImpl
    fun format(specifier: String): (n: Number) -> String = noImpl
    interface FormatPrefix {
        var symbol: String
        fun scale(n: Number): Number
    }
    fun formatPrefix(value: Number, precision: Number? = null): FormatPrefix = noImpl
    fun round(x: Number, n: Number? = null): Number = noImpl
    fun requote(string: String): String = noImpl
    interface `T$25` {
        /// TODO bug
//        @native("new")
//        fun invoke(r: Number, g: Number, b: Number): Rgb
//        @native("new")
//        fun invoke(color: String): Rgb
        @nativeInvoke
        fun invoke(r: Number, g: Number, b: Number): Rgb
        @nativeInvoke
        fun invoke(color: String): Rgb
    }
    var rgb: `T$25` = noImpl
    interface Rgb : Color {
        var r: Number
        var g: Number
        var b: Number
        fun brighter(k: Number? = null): Rgb
        fun darker(k: Number? = null): Rgb
        fun hsl(): Hsl
        override fun toString(): String
    }
    interface `T$26` {
//        @native("new")
//        fun invoke(h: Number, s: Number, l: Number): Hsl
//        @native("new")
//        fun invoke(color: String): Hsl
        @nativeInvoke
        fun invoke(h: Number, s: Number, l: Number): Hsl
        @nativeInvoke
        fun invoke(color: String): Hsl
    }
    var hsl: `T$26` = noImpl
    interface Hsl : Color {
        var h: Number
        var s: Number
        var l: Number
        fun brighter(k: Number? = null): Hsl
        fun darker(k: Number? = null): Hsl
        override fun rgb(): Rgb
        override fun toString(): String
    }
    interface `T$27` {
//        @native("new")
//        fun invoke(h: Number, c: Number, l: Number): Hcl
//        @native("new")
//        fun invoke(color: String): Hcl
        @nativeInvoke
        fun invoke(h: Number, c: Number, l: Number): Hcl
        @nativeInvoke
        fun invoke(color: String): Hcl
    }
    var hcl: `T$27` = noImpl
    interface Hcl : Color {
        var h: Number
        var c: Number
        var l: Number
        fun brighter(k: Number? = null): Hcl
        fun darker(k: Number? = null): Hcl
    }
    interface `T$28` {
//        @native("new")
//        fun invoke(l: Number, a: Number, b: Number): Lab
//        @native("new")
//        fun invoke(color: String): Lab
        @nativeInvoke
        fun invoke(l: Number, a: Number, b: Number): Lab
        @nativeInvoke
        fun invoke(color: String): Lab
    }
    var lab: `T$28` = noImpl
    interface Lab : Color {
        var l: Number
        var a: Number
        var b: Number
        fun brighter(k: Number? = null): Lab
        fun darker(k: Number? = null): Lab
        override fun rgb(): Rgb
        override fun toString(): String
    }
    interface `T$29` {
        @nativeInvoke
        fun invoke(): Color
//        @native("new")
//        fun invoke(): Color
    }
    var color: `T$29` = noImpl
    interface Color {
        fun rgb(): Rgb
    }
    @native
    object ns {
        interface Qualified {
            var space: String
            var local: String
        }
        interface `T$30` {
            @nativeGetter
            fun get(key: String): String?
            @nativeSetter
            fun set(key: String, value: String)
        }
        var prefix: `T$30` = noImpl
        fun qualify(name: String): dynamic /* Qualified | String */ = noImpl
    }
    ///TODO bug
//    fun <T : Function> functor(value: T): T = noImpl
    fun <T> functor(value: T): () -> T = noImpl
    fun rebind(target: Any, source: Any, vararg names: String): Any = noImpl
    fun dispatch(vararg names: String): Dispatch = noImpl
    interface Dispatch {
//        fun on(type: String): (vararg args: Any) -> Unit
//        fun on(type: String, listener: (vararg args: Any) -> Any): Dispatch
//        @nativeGetter
//        fun get(event: String): (vararg args: Any) -> Unit?
//        @nativeSetter
//        fun set(event: String, value: (vararg args: Any) -> Unit)
    }
    @native
    object scale {
        fun identity(): Identity = noImpl
        interface Identity {
            @nativeInvoke
            fun invoke(n: Number): Number
            fun invert(n: Number): Number
            fun domain(): Array<Number>
            fun domain(numbers: Array<Number>): Identity
            fun range(): Array<Number>
            fun range(numbers: Array<Number>): Identity
            fun ticks(count: Number? = null): Array<Number>
            fun tickFormat(count: Number? = null, format: String? = null): (n: Number) -> String
            fun copy(): Identity
        }
        fun linear(): Linear<Number, Number> = noImpl
//        fun <Output> linear(): Linear<Output, Output> = noImpl
        fun <Range, Output> linear(): Linear<Range, Output> = noImpl
        interface Linear<Range, Output> {
            @nativeInvoke
            operator fun invoke(x: Number): Output
            fun invert(y: Number): Number
            fun domain(): Array<Number>
            fun domain(numbers: Array<Number>): Linear<Range, Output>
            fun range(): Array<Range>
            fun range(values: Array<Range>): Linear<Range, Output>
            fun rangeRound(values: Array<Number>): Linear<Number, Number>
            fun interpolate(): (a: Range, b: Range) -> (t: Number) -> Output
            fun interpolate(factory: (a: Range, b: Range) -> (t: Number) -> Output): Linear<Range, Output>
            fun clamp(): Boolean
            fun clamp(clamp: Boolean): Linear<Range, Output>
            fun nice(count: Number? = null): Linear<Range, Output>
            fun ticks(count: Number? = null): Array<Number>
            fun tickFormat(count: Number? = null, format: String? = null): (n: Number) -> String
            fun copy(): Linear<Range, Output>
        }
        fun sqrt(): Pow<Number, Number> = noImpl
//        fun <Output> sqrt(): Pow<Output, Output> = noImpl
        fun <Range, Output> sqrt(): Pow<Range, Output> = noImpl
        fun pow(): Pow<Number, Number> = noImpl
//        fun <Output> pow(): Pow<Output, Output> = noImpl
        fun <Range, Output> pow(): Pow<Range, Output> = noImpl
        interface Pow<Range, Output> {
            @nativeInvoke
            fun invoke(x: Number): Output
            fun invert(y: Number): Number
            fun domain(): Array<Number>
            fun domain(numbers: Array<Number>): Pow<Range, Output>
            fun range(): Array<Range>
            fun range(values: Array<Range>): Pow<Range, Output>
            fun rangeRound(values: Array<Number>): Pow<Number, Number>
            fun exponent(): Number
            fun exponent(k: Number): Pow<Range, Output>
            fun interpolate(): (a: Range, b: Range) -> (t: Number) -> Output
            fun interpolate(factory: (a: Range, b: Range) -> (t: Number) -> Output): Pow<Range, Output>
            fun clamp(): Boolean
            fun clamp(clamp: Boolean): Pow<Range, Output>
            fun nice(m: Number? = null): Pow<Range, Output>
            fun ticks(count: Number? = null): Array<Number>
            fun tickFormat(count: Number? = null, format: String? = null): (n: Number) -> String
            fun copy(): Pow<Range, Output>
        }
        fun log(): Log<Number, Number> = noImpl
//        fun <Output> log(): Log<Output, Output> = noImpl
        fun <Range, Output> log(): Log<Range, Output> = noImpl
        interface Log<Range, Output> {
            @nativeInvoke
            fun invoke(x: Number): Output
            fun invert(y: Number): Number
            fun domain(): Array<Number>
            fun domain(numbers: Array<Number>): Log<Range, Output>
            fun range(): Array<Range>
            fun range(values: Array<Range>): Log<Range, Output>
            fun rangeRound(values: Array<Number>): Log<Number, Number>
            fun base(): Number
            fun base(base: Number): Log<Range, Output>
            fun interpolate(): (a: Range, b: Range) -> (t: Number) -> Output
            fun interpolate(factory: (a: Range, b: Range) -> (t: Number) -> Output): Log<Range, Output>
            fun clamp(): Boolean
            fun clamp(clamp: Boolean): Log<Range, Output>
            fun nice(): Log<Range, Output>
            fun ticks(): Array<Number>
            fun tickFormat(count: Number? = null, format: String? = null): (t: Number) -> String
            fun copy(): Log<Range, Output>
        }
        fun <T> quantize(): Quantize<T> = noImpl
        interface Quantize<T> {
            @nativeInvoke
            fun invoke(x: Number): T
            fun invertExtent(y: T): Pair<Number, Number>
            fun domain(): Array<Number>
            fun domain(numbers: Array<Number>): Quantize<T>
            fun range(): Array<T>
            fun range(values: Array<T>): Quantize<T>
            fun copy(): Quantize<T>
        }
        fun <T> quantile(): Quantile<T> = noImpl
        interface Quantile<T> {
            @nativeInvoke
            fun invoke(x: Number): T
            fun invertExtent(y: T): Pair<Number, Number>
            fun domain(): Array<Number>
            fun domain(numbers: Array<Number>): Quantile<T>
            fun range(): Array<T>
            fun range(values: Array<T>): Quantile<T>
            fun quantiles(): Array<Number>
            fun copy(): Quantile<T>
        }
//        fun <Range> threshold(): Threshold<Number, Range> = noImpl
        fun <Domain, Range> threshold(): Threshold<Domain, Range> = noImpl
        interface Threshold<Domain, Range> {
            @nativeInvoke
            fun invoke(x: Number): Range
            fun invertExtent(y: Range): Pair<Domain, Domain>
            fun domain(): Array<Domain>
            fun domain(domain: Array<Domain>): Threshold<Domain, Range>
            fun range(): Array<Range>
            fun range(values: Array<Range>): Threshold<Domain, Range>
            fun copy(): Threshold<Domain, Range>
        }
//        fun <Range> ordinal(): Ordinal<String, Range> = noImpl
        interface `T$31` {
            ///TODO bug
            override fun toString(): String
        }
        fun <Domain : `T$36`, Range> ordinal(): Ordinal<Domain, Range> = noImpl
        //TODO bug
        fun category10(): Ordinal<*, String> = noImpl
        ///TODO bug with caches
        interface `T$32` {
            override fun toString(): String
        }
        fun <Domain : `T$36`> category10(): Ordinal<Domain, String> = noImpl
        fun category20(): Ordinal<*, String> = noImpl
        interface `T$33` {
            override fun toString(): String
        }
        fun <Domain : `T$36`> category20(): Ordinal<Domain, String> = noImpl
        fun category20b(): Ordinal<*, String> = noImpl
        interface `T$34` {
            override fun toString(): String
        }
        fun <Domain : `T$36`> category20b(): Ordinal<Domain, String> = noImpl
        fun category20c(): Ordinal<*, String> = noImpl
        interface `T$35` {
            override fun toString(): String
        }
        fun <Domain : `T$36`> category20c(): Ordinal<Domain, String> = noImpl
        interface `T$36` {
            override fun toString(): String
        }
        interface Ordinal<Domain : `T$36`, Range> {
            @nativeInvoke
            fun invoke(x: Domain): Range
            fun domain(): Array<Domain>
            fun domain(values: Array<Domain>): Ordinal<Domain, Range>
            fun range(): Array<Range>
            fun range(values: Array<Range>): Ordinal<Domain, Range>
            fun rangePoints(interval: Pair<Number, Number>, padding: Number? = null): Ordinal<Domain, Number>
            fun rangeRoundPoints(interval: Pair<Number, Number>, padding: Number? = null): Ordinal<Domain, Number>
            fun rangeBands(interval: Pair<Number, Number>, padding: Number? = null, outerPadding: Number? = null): Ordinal<Domain, Number>
            fun rangeRoundBands(interval: Pair<Number, Number>, padding: Number? = null, outerPadding: Number? = null): Ordinal<Domain, Number>
            fun rangeBand(): Number
            fun rangeExtent(): Pair<Number, Number>
            fun copy(): Ordinal<Domain, Range>
        }
    }
    fun interpolate(a: Number, b: Number): (t: Number) -> Number = noImpl
    fun interpolate(a: String, b: String): (t: Number) -> String = noImpl
    fun interpolate(a: String, b: Color): (t: Number) -> String = noImpl
    fun interpolate(a: Color, b: Color): (t: Number) -> String = noImpl
    fun interpolate(a: Array<dynamic /* String | Color */>, b: Array<Color>): (t: Number) -> String = noImpl
    fun <Range, Output> interpolate(a: Array<Range>, b: Array<Output>): (t: Number) -> Array<Output> = noImpl
    fun <Range, Output> interpolate(a: Array<Range>, b: Array<Range>): (t: Number) -> Array<Output> = noImpl
    interface `T$37` {
        @nativeGetter
        fun get(key: String): dynamic /* String | Color */
        @nativeSetter
        fun set(key: String, value: String)
        @nativeSetter
        fun set(key: String, value: Color)
    }
    interface `T$38` {
        @nativeGetter
        fun get(key: String): Color?
        @nativeSetter
        fun set(key: String, value: Color)
    }
    interface `T$39` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    fun interpolate(a: `T$37`, b: `T$38`): (t: Number) -> `T$39` = noImpl
    interface `T$40`<Range> {
        @nativeGetter
        fun get(key: String): Range?
        @nativeSetter
        fun set(key: String, value: Range)
    }
    interface `T$41`<Output> {
        @nativeGetter
        fun get(key: String): Output?
        @nativeSetter
        fun set(key: String, value: Output)
    }
    fun <Range, Output> interpolate(a: `T$40`<Range>, b: `T$41`<Output>): (t: Number) -> `T$41`<Output> = noImpl
    interface `T$42`<Range> {
        @nativeGetter
        fun get(key: String): Range?
        @nativeSetter
        fun set(key: String, value: Range)
    }
    interface `T$43`<Output> {
        @nativeGetter
        fun get(key: String): Output?
        @nativeSetter
        fun set(key: String, value: Output)
    }
    // TODO bug
//    fun <Range, Output> interpolate(a: `T$42`<Range>, b: `T$42`<Range>): `(t: Number) -> `T$43`<Output>` = noImpl
    fun <Range, Output> interpolate(a: `T$42`<Range>, b: `T$42`<Range>): (t: Number) -> `T$43`<Output> = noImpl
    fun interpolateNumber(a: Number, b: Number): (t: Number) -> Number = noImpl
    fun interpolateRound(a: Number, b: Number): (t: Number) -> Number = noImpl
    fun interpolateString(a: String, b: String): (t: Number) -> String = noImpl
    fun interpolateRgb(a: String, b: String): (t: Number) -> String = noImpl
    fun interpolateRgb(a: String, b: Color): (t: Number) -> String = noImpl
    fun interpolateRgb(a: Color, b: String): (t: Number) -> String = noImpl
    fun interpolateRgb(a: Color, b: Color): (t: Number) -> String = noImpl
    fun interpolateHsl(a: String, b: String): (t: Number) -> String = noImpl
    fun interpolateHsl(a: String, b: Color): (t: Number) -> String = noImpl
    fun interpolateHsl(a: Color, b: String): (t: Number) -> String = noImpl
    fun interpolateHsl(a: Color, b: Color): (t: Number) -> String = noImpl
    fun interpolateLab(a: String, b: String): (t: Number) -> String = noImpl
    fun interpolateLab(a: String, b: Color): (t: Number) -> String = noImpl
    fun interpolateLab(a: Color, b: String): (t: Number) -> String = noImpl
    fun interpolateLab(a: Color, b: Color): (t: Number) -> String = noImpl
    fun interpolateHcl(a: String, b: String): (t: Number) -> String = noImpl
    fun interpolateHcl(a: String, b: Color): (t: Number) -> String = noImpl
    fun interpolateHcl(a: Color, b: String): (t: Number) -> String = noImpl
    fun interpolateHcl(a: Color, b: Color): (t: Number) -> String = noImpl
    fun interpolateArray(a: Array<dynamic /* String | Color */>, b: Array<Color>): (t: Number) -> Array<String> = noImpl
    fun <Range, Output> interpolateArray(a: Array<Range>, b: Array<Range>): (t: Number) -> Array<Output> = noImpl
    fun <Range, Output> interpolateArray(a: Array<Range>, b: Array<Output>): (t: Number) -> Array<Output> = noImpl
    interface `T$44` {
        @nativeGetter
        fun get(key: String): dynamic /* String | Color */
        @nativeSetter
        fun set(key: String, value: String)
        @nativeSetter
        fun set(key: String, value: Color)
    }
    interface `T$45` {
        @nativeGetter
        fun get(key: String): Color?
        @nativeSetter
        fun set(key: String, value: Color)
    }
    interface `T$46` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    fun interpolateObject(a: `T$44`, b: `T$45`): (t: Number) -> `T$46` = noImpl
    interface `T$47`<Range> {
        @nativeGetter
        fun get(key: String): Range?
        @nativeSetter
        fun set(key: String, value: Range)
    }
    interface `T$48`<Output> {
        @nativeGetter
        fun get(key: String): Output?
        @nativeSetter
        fun set(key: String, value: Output)
    }
    fun <Range, Output> interpolateObject(a: `T$47`<Range>, b: `T$48`<Output>): (t: Number) -> `T$48`<Output> = noImpl
    interface `T$49`<Range> {
        @nativeGetter
        fun get(key: String): Range?
        @nativeSetter
        fun set(key: String, value: Range)
    }
    interface `T$50`<Output> {
        @nativeGetter
        fun get(key: String): Output?
        @nativeSetter
        fun set(key: String, value: Output)
    }
    fun <Range, Output> interpolateObject(a: `T$49`<Range>, b: `T$49`<Range>): (t: Number) -> `T$50`<Output> = noImpl
    fun interpolateTransform(a: String, b: String): (t: Number) -> String = noImpl
    fun interpolateTransform(a: String, b: Transform): (t: Number) -> String = noImpl
    fun interpolateTransform(a: Transform, b: String): (t: Number) -> String = noImpl
    fun interpolateTransform(a: Transform, b: Transform): (t: Number) -> String = noImpl
    interface `T$51` {
        @nativeInvoke
        fun invoke(t: Number): Triple<Number, Number, Number>
        var duration: Number
    }
    fun interpolateZoom(a: Triple<Number, Number, Number>, b: Triple<Number, Number, Number>): `T$51` = noImpl
    var interpolators: Array<(a: Any, b: Any) -> (t: Number) -> Any> = noImpl
    @native
    object time {
        var second: Interval = noImpl
        var minute: Interval = noImpl
        var hour: Interval = noImpl
        var day: Interval = noImpl
        var week: Interval = noImpl
        var sunday: Interval = noImpl
        var monday: Interval = noImpl
        var tuesday: Interval = noImpl
        var wednesday: Interval = noImpl
        var thursday: Interval = noImpl
        var friday: Interval = noImpl
        var saturday: Interval = noImpl
        var month: Interval = noImpl
        var year: Interval = noImpl
        interface `T$52` {
            @nativeInvoke
            fun invoke(d: Date): Date
            fun floor(d: Date): Date
            fun round(d: Date): Date
            fun ceil(d: Date): Date
            fun range(start: Date, stop: Date, step: Number? = null): Array<Date>
            fun offset(date: Date, step: Number): Date
        }
        interface Interval {
            @nativeInvoke
            fun invoke(d: Date): Date
            fun floor(d: Date): Date
            fun round(d: Date): Date
            fun ceil(d: Date): Date
            fun range(start: Date, stop: Date, step: Number? = null): Array<Date>
            fun offset(date: Date, step: Number): Date
            var utc: `T$52`
        }
        fun seconds(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun minutes(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun hours(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun days(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun weeks(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun sundays(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun mondays(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun tuesdays(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun wednesdays(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun thursdays(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun fridays(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun saturdays(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun months(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun years(start: Date, stop: Date, step: Number? = null): Array<Date> = noImpl
        fun dayOfYear(d: Date): Number = noImpl
        fun weekOfYear(d: Date): Number = noImpl
        fun sundayOfYear(d: Date): Number = noImpl
        fun mondayOfYear(d: Date): Number = noImpl
        fun tuesdayOfYear(d: Date): Number = noImpl
        fun wednesdayOfYear(d: Date): Number = noImpl
        fun fridayOfYear(d: Date): Number = noImpl
        fun saturdayOfYear(d: Date): Number = noImpl
        fun format(specifier: String): Format = noImpl
        @native
        object format {
            fun multi(formats: Array<Pair<String, (d: Date) -> dynamic /* Boolean | Number */>>): Format = noImpl
            fun utc(specifier: String): Format = noImpl
            @native
            object utc {
                fun multi(formats: Array<Pair<String, (d: Date) -> dynamic /* Boolean | Number */>>): Format = noImpl
            }
            var iso: Format = noImpl
        }
        interface Format {
            @nativeInvoke
            fun invoke(d: Date): String
            fun parse(input: String): Date
        }
        fun scale(): Scale<Number, Number> = noImpl
//        fun <Output> scale(): Scale<Output, Output> = noImpl
        fun <Range, Output> scale(): Scale<Range, Output> = noImpl
        @native
        object scale {
            fun utc(): Scale<Number, Number> = noImpl
//            fun <Output> utc(): Scale<Output, Output> = noImpl
            fun <Range, Output> utc(): Scale<Range, Output> = noImpl
        }
        interface Scale<Range, Output> {
            @nativeInvoke
            operator fun invoke(x: Date): Output
            fun invert(y: Number): Date
            fun domain(): Array<Date>
            fun domain(dates: Array<Number>): Scale<Range, Output>
            fun domain(dates: Array<Date>): Scale<Range, Output>
            fun nice(): Scale<Range, Output>
            fun nice(interval: Interval, step: Number? = null): Scale<Range, Output>
            fun range(): Array<Range>
            fun range(values: Array<Range>): Scale<Range, Output>
            fun rangeRound(values: Array<Number>): Scale<Number, Number>
            fun interpolate(): (a: Range, b: Range) -> (t: Number) -> Output
            fun interpolate(factory: (a: Range, b: Range) -> (t: Number) -> Output): Scale<Range, Output>
            fun clamp(): Boolean
            fun clamp(clamp: Boolean): Scale<Range, Output>
            fun ticks(): Array<Date>
            fun ticks(interval: Interval, step: Number? = null): Array<Date>
            fun ticks(count: Number): Array<Date>
            fun tickFormat(count: Number): (d: Date) -> String
            fun copy(): Scale<Range, Output>
        }
    }
    @native
    object behavior {
        fun <Datum> drag(): Drag<Datum> = noImpl
        interface `T$53` {
            var x: Number
            var y: Number
        }
        interface `T$54` {
            var x: Number
            var y: Number
        }
        interface Drag<Datum> {
            @nativeInvoke
            fun invoke(selection: Selection<Datum>)
            fun on(type: String): (d: Datum, i: Number) -> Any
            fun on(type: String, listener: (d: Datum, i: Number) -> Any): Drag<Datum>
            fun origin(): (d: Datum, i: Number) -> `T$53`
            fun origin(accessor: (d: Datum, i: Number) -> `T$54`): Drag<Datum>
        }
        fun <Datum> zoom(): Zoom<Datum> = noImpl
        @native
        object zoom {
            interface Scale {
                fun domain(): Array<Number>
                fun domain(values: Array<Number>): Scale
                fun invert(y: Number): Number
                fun range(values: Array<Number>): Scale
                fun range(): Array<Number>
            }
        }
        interface Zoom<Datum> {
            @nativeInvoke
            fun invoke(selection: Selection<Datum>)
            fun translate(): Pair<Number, Number>
            fun translate(translate: Pair<Number, Number>): Zoom<Datum>
            fun scale(): Number
            fun scale(scale: Number): Zoom<Datum>
            fun scaleExtent(): Pair<Number, Number>
            fun scaleExtent(extent: Pair<Number, Number>): Zoom<Datum>
            fun center(): Pair<Number, Number>
            fun center(center: Pair<Number, Number>): Zoom<Datum>
            fun size(): Pair<Number, Number>
            fun size(size: Pair<Number, Number>): Zoom<Datum>
            fun x(): zoom.Scale
            fun x(x: zoom.Scale): Zoom<Datum>
            fun y(): zoom.Scale
            fun y(y: zoom.Scale): Zoom<Datum>
            fun on(type: String): (d: Datum, i: Number) -> Any
            fun on(type: String, listener: (d: Datum, i: Number) -> Any): Zoom<Datum>
            fun event(selection: Selection<Datum>)
            fun event(transition: Transition<Datum>)
        }
    }
    @native
    object geo {
        fun path(): Path = noImpl
        interface Path {
            @nativeInvoke
            fun invoke(feature: Any, index: Number? = null): String
            fun area(feature: Any): Number
            fun centroid(feature: Any): Pair<Number, Number>
            fun bounds(feature: Any): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun projection(): dynamic /* Transform | (coordinates: Pair<Number, Number>) -> Pair<Number, Number> */
            fun projection(stream: Transform): Path
            fun projection(projection: (coordinates: Pair<Number, Number>) -> Pair<Number, Number>): Path
            fun pointRadius(): dynamic /* Number | (datum: Any, index: Number) -> Number */
            fun pointRadius(radius: Number): Path
            fun pointRadius(radius: (datum: Any, index: Number) -> Number): Path
            fun context(): CanvasRenderingContext2D
            fun context(context: CanvasRenderingContext2D): Path
        }
        fun graticule(): Graticule = noImpl
        interface Graticule {
            @nativeInvoke
            fun invoke(): Any
            fun lines(): Array<Any>
            fun outline(): Any
            fun extent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun extent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): Graticule
            fun majorExtent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun majorExtent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): Graticule
            fun minorExtent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun minorExtent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): Graticule
            fun step(): Pair<Number, Number>
            fun step(step: Pair<Number, Number>): Graticule
            fun majorStep(): Pair<Number, Number>
            fun majorStep(step: Pair<Number, Number>): Graticule
            fun minorStep(): Pair<Number, Number>
            fun minorStep(step: Pair<Number, Number>): Graticule
            fun precision(): Number
            fun precision(precision: Number): Graticule
        }
        fun circle(): Circle = noImpl
        interface Circle {
            @nativeInvoke
            fun invoke(vararg args: Any): Any
            fun origin(): dynamic /* Pair<Number, Number> | (vararg args: Any) -> Pair<Number, Number> */
            fun origin(origin: Pair<Number, Number>): Circle
            // TODO bug
//            fun origin(origin: (vararg args: Any) -> Pair<Number, Number>): Circle
            fun angle(): Number
            fun angle(angle: Number): Circle
            fun precision(): Number
            fun precision(precision: Number): Circle
        }
        fun area(feature: Any): Number = noImpl
        fun centroid(feature: Any): Pair<Number, Number> = noImpl
        fun bounds(feature: Any): Pair<Pair<Number, Number>, Pair<Number, Number>> = noImpl
        fun distance(a: Pair<Number, Number>, b: Pair<Number, Number>): Number = noImpl
        fun length(feature: Any): Number = noImpl
        fun interpolate(a: Pair<Number, Number>, b: Pair<Number, Number>): (t: Number) -> Pair<Number, Number> = noImpl
        fun rotation(rotate: Pair<Number, Number>): Rotation = noImpl
        fun rotation(rotate: Triple<Number, Number, Number>): Rotation = noImpl
        interface Rotation {
            @nativeInvoke
            fun invoke(location: Pair<Number, Number>): Pair<Number, Number>
            fun invert(location: Pair<Number, Number>): Pair<Number, Number>
        }
        fun stream(`object`: Any, listener: Listener): Unit = noImpl
        interface Listener {
            fun point(x: Number, y: Number, z: Number)
            fun lineStart()
            fun lineEnd()
            fun polygonStart()
            fun polygonEnd()
            fun sphere()
        }
        fun transform(methods: TransformMethods): Transform = noImpl
        interface TransformMethods {
            val point: ((x: Number, y: Number, z: Number) -> Unit)? get() = noImpl
            val lineStart: (() -> Unit)? get() = noImpl
            val lineEnd: (() -> Unit)? get() = noImpl
            val polygonStart: (() -> Unit)? get() = noImpl
            val polygonEnd: (() -> Unit)? get() = noImpl
            val sphere: (() -> Unit)? get() = noImpl
        }
        interface Transform {
            fun stream(stream: Listener): Listener
        }
        fun clipExtent(): ClipExtent = noImpl
        interface ClipExtent : Transform {
            fun extent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun extent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): ClipExtent
        }
        fun projection(raw: RawInvertibleProjection): InvertibleProjection = noImpl
        fun projection(raw: RawProjection): Projection = noImpl
//        fun projectionMutator(factory: (vararg args: Any) -> RawInvertibleProjection): (vararg args: Any) -> InvertibleProjection = noImpl
//        fun projectionMutator(factory: (vararg args: Any) -> RawProjection): (vararg args: Any) -> Projection = noImpl
        fun albers(): ConicProjection = noImpl
        fun albersUsa(): ConicProjection = noImpl
        fun azimuthalEqualArea(): InvertibleProjection = noImpl
        @native
        object azimuthalEqualArea {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        fun azimuthalEquidistant(): InvertibleProjection = noImpl
        @native
        object azimuthalEquidistant {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        fun conicConformal(): ConicProjection = noImpl
        @native
        object conicConformal {
            fun raw(phi0: Number, phi1: Number): RawInvertibleProjection = noImpl
        }
        fun conicEqualArea(): ConicProjection = noImpl
        @native
        object conicEqualArea {
            fun raw(phi0: Number, phi1: Number): RawInvertibleProjection = noImpl
        }
        fun conicEquidistant(): ConicProjection = noImpl
        @native
        object conicEquidistant {
            fun raw(phi0: Number, phi1: Number): RawInvertibleProjection = noImpl
        }
        fun equirectangular(): InvertibleProjection = noImpl
        @native
        object equirectangular {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        fun gnomonic(): InvertibleProjection = noImpl
        @native
        object gnomonic {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        fun mercator(): InvertibleProjection = noImpl
        @native
        object mercator {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        fun orthographic(): InvertibleProjection = noImpl
        @native
        object orthographic {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        fun stereographic(): InvertibleProjection = noImpl
        @native
        object stereographic {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        fun transverseMercator(): InvertibleProjection = noImpl
        @native
        object transverseMercator {
            fun raw(lambda: Number, phi: Number): Pair<Number, Number> = noImpl
            @native
            object raw {
                fun invert(x: Number, y: Number): Pair<Number, Number> = noImpl
            }
        }
        interface Projection {
            @nativeInvoke
            fun invoke(location: Pair<Number, Number>): Pair<Number, Number>
            fun rotate(): Triple<Number, Number, Number>
            fun rotate(rotation: Triple<Number, Number, Number>): Projection
            fun center(): Pair<Number, Number>
            fun center(location: Pair<Number, Number>): Projection
            fun translate(): Pair<Number, Number>
            fun translate(point: Pair<Number, Number>): Projection
            fun scale(): Number
            fun scale(scale: Number): Projection
            fun clipAngle(): Number
            fun clipAngle(angle: Number): Projection
            fun clipExtent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun clipExtent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): Projection
            fun precision(): Number
            fun precision(precision: Number): Projection
            fun stream(listener: Listener): Listener
        }
        interface InvertibleProjection : Projection {
            fun invert(point: Pair<Number, Number>): Pair<Number, Number>
        }
        interface ConicProjection : InvertibleProjection {
            fun parallels(): Pair<Number, Number>
            fun parallels(parallels: Pair<Number, Number>): ConicProjection
            override fun rotate(): Triple<Number, Number, Number>
            override fun rotate(rotation: Triple<Number, Number, Number>): ConicProjection
            override fun center(): Pair<Number, Number>
            override fun center(location: Pair<Number, Number>): ConicProjection
            override fun translate(): Pair<Number, Number>
            override fun translate(point: Pair<Number, Number>): ConicProjection
            override fun scale(): Number
            override fun scale(scale: Number): ConicProjection
            override fun clipAngle(): Number
            override fun clipAngle(angle: Number): ConicProjection
            override fun clipExtent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            override fun clipExtent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): ConicProjection
            override fun precision(): Number
            override fun precision(precision: Number): ConicProjection
        }
        interface RawProjection {
            @nativeInvoke
            fun invoke(lambda: Number, phi: Number): Pair<Number, Number>
        }
        interface RawInvertibleProjection : RawProjection {
            fun invert(x: Number, y: Number): Pair<Number, Number>
        }
    }
    @native
    object svg {
        fun line(): Line<Pair<Number, Number>> = noImpl
        fun <T> line(): Line<T> = noImpl
        interface Line<T> {
            @nativeInvoke
            fun invoke(data: Array<T>): String
            fun x(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun x(x: Number): Line<T>
            fun x(x: (d: T, i: Number) -> Number): Line<T>
            fun y(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun y(x: Number): Line<T>
            fun y(y: (d: T, i: Number) -> Number): Line<T>
            fun interpolate(): dynamic /* String | (points: Array<Pair<Number, Number>>) -> String */
            // TODO bug
//            fun interpolate(interpolate: Any /* "linear" */): Line<T>
//            fun interpolate(interpolate: Any /* "linear-closed" */): Line<T>
//            fun interpolate(interpolate: Any /* "step" */): Line<T>
//            fun interpolate(interpolate: Any /* "step-before" */): Line<T>
//            fun interpolate(interpolate: Any /* "step-after" */): Line<T>
//            fun interpolate(interpolate: Any /* "basis" */): Line<T>
//            fun interpolate(interpolate: Any /* "basis-open" */): Line<T>
//            fun interpolate(interpolate: Any /* "basis-closed" */): Line<T>
//            fun interpolate(interpolate: Any /* "bundle" */): Line<T>
//            fun interpolate(interpolate: Any /* "cardinal" */): Line<T>
//            fun interpolate(interpolate: Any /* "cardinal-open" */): Line<T>
//            fun interpolate(interpolate: Any /* "cardinal-closed" */): Line<T>
//            fun interpolate(interpolate: Any /* "monotone" */): Line<T>
            fun interpolate(interpolate: String): Line<T>
            fun interpolate(interpolate: (points: Array<Pair<Number, Number>>) -> String): Line<T>
            fun tension(): Number
            fun tension(tension: Number): Line<T>
            fun defined(): (d: T, i: Number) -> Boolean
            fun defined(defined: (d: T, i: Number) -> Boolean): Line<T>
        }
        @native
        object line {
            fun radial(): Radial<Pair<Number, Number>> = noImpl
            fun <T> radial(): Radial<T> = noImpl
            interface Radial<T> {
                @nativeInvoke
                fun invoke(data: Array<T>): String
                fun radius(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun radius(radius: Number): Radial<T>
                fun radius(radius: (d: T, i: Number) -> Number): Radial<T>
                fun angle(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun angle(angle: Number): Radial<T>
                fun angle(angle: (d: T, i: Number) -> Number): Radial<T>
                fun interpolate(): dynamic /* String | (points: Array<Pair<Number, Number>>) -> String */
//                fun interpolate(interpolate: Any /* "linear" */): Radial<T>
//                fun interpolate(interpolate: Any /* "linear-closed" */): Radial<T>
//                fun interpolate(interpolate: Any /* "step" */): Radial<T>
//                fun interpolate(interpolate: Any /* "step-before" */): Radial<T>
//                fun interpolate(interpolate: Any /* "step-after" */): Radial<T>
//                fun interpolate(interpolate: Any /* "basis" */): Radial<T>
//                fun interpolate(interpolate: Any /* "basis-open" */): Radial<T>
//                fun interpolate(interpolate: Any /* "basis-closed" */): Radial<T>
//                fun interpolate(interpolate: Any /* "bundle" */): Radial<T>
//                fun interpolate(interpolate: Any /* "cardinal" */): Radial<T>
//                fun interpolate(interpolate: Any /* "cardinal-open" */): Radial<T>
//                fun interpolate(interpolate: Any /* "cardinal-closed" */): Radial<T>
//                fun interpolate(interpolate: Any /* "monotone" */): Radial<T>
                fun interpolate(interpolate: String): Radial<T>
                fun interpolate(interpolate: (points: Array<Pair<Number, Number>>) -> String): Radial<T>
                fun tension(): Number
                fun tension(tension: Number): Radial<T>
                fun defined(): (d: T, i: Number) -> Boolean
                fun defined(defined: (d: T, i: Number) -> Boolean): Radial<T>
            }
        }
        fun area(): Area<Pair<Number, Number>> = noImpl
        fun <T> area(): Area<T> = noImpl
        interface Area<T> {
            @nativeInvoke
            fun invoke(data: Array<T>): String
            fun x(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun x(x: Number): Area<T>
            fun x(x: (d: T, i: Number) -> Number): Area<T>
            fun x0(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun x0(x0: Number): Area<T>
            fun x0(x0: (d: T, i: Number) -> Number): Area<T>
            fun x1(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun x1(x1: Number): Area<T>
            fun x1(x1: (d: T, i: Number) -> Number): Area<T>
            fun y(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun y(y: Number): Area<T>
            fun y(y: (d: T, i: Number) -> Number): Area<T>
            fun y0(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun y0(y0: Number): Area<T>
            fun y0(y0: (d: T, i: Number) -> Number): Area<T>
            fun y1(): dynamic /* Number | (d: T, i: Number) -> Number */
            fun y1(y1: Number): Area<T>
            fun y1(y1: (d: T, i: Number) -> Number): Area<T>
            fun interpolate(): dynamic /* String | (points: Array<Pair<Number, Number>>) -> String */
//            fun interpolate(interpolate: Any /* "linear" */): Area<T>
//            fun interpolate(interpolate: Any /* "step" */): Area<T>
//            fun interpolate(interpolate: Any /* "step-before" */): Area<T>
//            fun interpolate(interpolate: Any /* "step-after" */): Area<T>
//            fun interpolate(interpolate: Any /* "basis" */): Area<T>
//            fun interpolate(interpolate: Any /* "basis-open" */): Area<T>
//            fun interpolate(interpolate: Any /* "cardinal" */): Area<T>
//            fun interpolate(interpolate: Any /* "cardinal-open" */): Area<T>
//            fun interpolate(interpolate: Any /* "monotone" */): Area<T>
            fun interpolate(interpolate: String): Area<T>
            fun interpolate(interpolate: (points: Array<Pair<Number, Number>>) -> String): Area<T>
            fun tension(): Number
            fun tension(tension: Number): Area<T>
            fun defined(): (d: T, i: Number) -> Boolean
            fun defined(defined: (d: T, i: Number) -> Boolean): Area<T>
        }
        @native
        object area {
            fun radial(): Radial<Pair<Number, Number>> = noImpl
            fun <T> radial(): Radial<T> = noImpl
            interface Radial<T> {
                @nativeInvoke
                fun invoke(data: Array<T>): String
                fun radius(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun radius(radius: Number): Radial<T>
                fun radius(radius: (d: T, i: Number) -> Number): Radial<T>
                fun innerRadius(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun innerRadius(innerRadius: Number): Radial<T>
                fun innerRadius(innerRadius: (d: T, i: Number) -> Number): Radial<T>
                fun outerRadius(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun outerRadius(outerRadius: Number): Radial<T>
                fun outerRadius(outerRadius: (d: T, i: Number) -> Number): Radial<T>
                fun angle(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun angle(angle: Number): Radial<T>
                fun angle(angle: (d: T, i: Number) -> Number): Radial<T>
                fun startAngle(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun startAngle(startAngle: Number): Radial<T>
                fun startAngle(startAngle: (d: T, i: Number) -> Number): Radial<T>
                fun endAngle(): dynamic /* Number | (d: T, i: Number) -> Number */
                fun endAngle(endAngle: Number): Radial<T>
                fun endAngle(endAngle: (d: T, i: Number) -> Number): Radial<T>
                fun interpolate(): dynamic /* String | (points: Array<Pair<Number, Number>>) -> String */
//                fun interpolate(interpolate: Any /* "linear" */): Radial<T>
//                fun interpolate(interpolate: Any /* "step" */): Radial<T>
//                fun interpolate(interpolate: Any /* "step-before" */): Radial<T>
//                fun interpolate(interpolate: Any /* "step-after" */): Radial<T>
//                fun interpolate(interpolate: Any /* "basis" */): Radial<T>
//                fun interpolate(interpolate: Any /* "basis-open" */): Radial<T>
//                fun interpolate(interpolate: Any /* "cardinal" */): Radial<T>
//                fun interpolate(interpolate: Any /* "cardinal-open" */): Radial<T>
//                fun interpolate(interpolate: Any /* "monotone" */): Radial<T>
                fun interpolate(interpolate: String): Radial<T>
                fun interpolate(interpolate: (points: Array<Pair<Number, Number>>) -> String): Radial<T>
                fun tension(): Number
                fun tension(tension: Number): Radial<T>
                fun defined(): (d: T, i: Number) -> Boolean
                fun defined(defined: (d: T, i: Number) -> Boolean): Radial<T>
            }
        }
        fun arc(): Arc<arc.Arc> = noImpl
        fun <T> arc(): Arc<T> = noImpl
        @native
        object arc {
            interface Arc {
                var innerRadius: Number
                var outerRadius: Number
                var startAngle: Number
                var endAngle: Number
                var padAngle: Number
            }
        }
        interface Arc<T> {
            @nativeInvoke
            fun invoke(d: T, i: Number? = null): String
            fun innerRadius(): (d: T, i: Number) -> Number
            fun innerRadius(radius: Number): Arc<T>
            fun innerRadius(radius: (d: T, i: Number) -> Number): Arc<T>
            fun outerRadius(): (d: T, i: Number) -> Number
            fun outerRadius(radius: Number): Arc<T>
            fun outerRadius(radius: (d: T, i: Number) -> Number): Arc<T>
            fun cornerRadius(): (d: T, i: Number) -> Number
            fun cornerRadius(radius: Number): Arc<T>
            fun cornerRadius(radius: (d: T, i: Number) -> Number): Arc<T>
            fun padRadius(): dynamic /* String | (d: T, i: Number) -> Number */
            fun padRadius(radius: Any /* "auto" */): Arc<T>
            fun padRadius(radius: String): Arc<T>
            fun padRadius(radius: (d: T, i: Number) -> Number): Arc<T>
            fun startAngle(): (d: T, i: Number) -> Number
            fun startAngle(angle: Number): Arc<T>
            fun startAngle(angle: (d: T, i: Number) -> Number): Arc<T>
            fun endAngle(): (d: T, i: Number) -> Number
            fun endAngle(angle: Number): Arc<T>
            fun endAngle(angle: (d: T, i: Number) -> Number): Arc<T>
            fun padAngle(): (d: T, i: Number) -> Number
            fun padAngle(angle: Number): Arc<T>
            fun padAngle(angle: (d: T, i: Number) -> Number): Arc<T>
            fun centroid(d: T, i: Number? = null): Pair<Number, Number>
        }
        fun symbol(): Symbol<Any> = noImpl
        fun <T> symbol(): Symbol<T> = noImpl
        interface Symbol<T> {
            @nativeInvoke
            fun invoke(d: T, i: Number? = null): String
            fun type(): (d: T, i: Number) -> String
            fun type(type: String): Symbol<T>
            fun type(type: (d: T, i: Number) -> String): Symbol<T>
            fun size(): (d: T, i: String) -> Number
            fun size(size: Number): Symbol<T>
            fun size(size: (d: T, i: Number) -> Number): Symbol<T>
        }
        var symbolTypes: Array<String> = noImpl
        fun chord(): Chord<chord.Link<chord.Node>, chord.Node> = noImpl
        // TODO bug
//        fun <Node> chord(): Chord<chord.Link<Node>, Node> = noImpl
        fun <Link, Node> chord(): Chord<Link, Node> = noImpl
        @native
        object chord {
            interface Link<Node> {
                var source: Node
                var target: Node
            }
            interface Node {
                var radius: Number
                var startAngle: Number
                var endAngle: Number
            }
        }
        interface Chord<Link, Node> {
            @nativeInvoke
            fun invoke(d: Link, i: Number): String
            fun source(): (d: Link, i: Number) -> Node
            fun source(source: Node): Chord<Link, Node>
            fun source(source: (d: Link, i: Number) -> Node): Chord<Link, Node>
            fun target(): (d: Link, i: Number) -> Node
            fun target(target: Node): Chord<Link, Node>
            fun target(target: (d: Link, i: Number) -> Node): Chord<Link, Node>
            fun radius(): (d: Node, i: Number) -> Number
            fun radius(radius: Number): Chord<Link, Node>
            fun radius(radius: (d: Node, i: Number) -> Number): Chord<Link, Node>
            fun startAngle(): (d: Node, i: Number) -> Number
            fun startAngle(angle: Number): Chord<Link, Node>
            fun startAngle(angle: (d: Node, i: Number) -> Number): Chord<Link, Node>
            fun endAngle(): (d: Node, i: Number) -> Number
            fun endAngle(angle: Number): Chord<Link, Node>
            fun endAngle(angle: (d: Node, i: Number) -> Number): Chord<Link, Node>
        }
        fun diagonal(): Diagonal<diagonal.Link<diagonal.Node>, diagonal.Node> = noImpl
//        fun <Node> diagonal(): Diagonal<diagonal.Link<Node>, Node> = noImpl
        fun <Link, Node> diagonal(): Diagonal<Link, Node> = noImpl
        @native
        object diagonal {
            interface Link<Node> {
                var source: Node
                var target: Node
            }
            interface Node {
                var x: Number
                var y: Number
            }
            fun radial(): Radial<Link<Node>, Node> = noImpl
//            fun <Node> radial(): Radial<Link<Node>, Node> = noImpl
            fun <Link, Node> radial(): Radial<Link, Node> = noImpl
            interface Radial<Link, Node> {
                @nativeInvoke
                fun invoke(d: Link, i: Number): String
                fun source(): (d: Link, i: Number) -> Node
                fun source(source: Node): Radial<Link, Node>
                fun source(source: (d: Link, i: Number) -> Node): Radial<Link, Node>
                fun target(): (d: Link, i: Number) -> Node
                fun target(target: Node): Radial<Link, Node>
                fun target(target: (d: Link, i: Number) -> Node): Radial<Link, Node>
                fun projection(): (d: Node, i: Number) -> Pair<Number, Number>
                fun projection(projection: (d: Node, i: Number) -> Pair<Number, Number>): Radial<Link, Node>
            }
        }
        interface `T$55` {
            var x: Number
            var y: Number
        }
        interface `T$56` {
            var x: Number
            var y: Number
        }
        interface Diagonal<Link, Node> {
            @nativeInvoke
            fun invoke(d: Link, i: Number? = null): String
            fun source(): (d: Link, i: Number) -> Node
            fun source(source: Node): Diagonal<Link, Node>
            fun source(source: (d: Link, i: Number) -> `T$55`): Diagonal<Link, Node>
            fun target(): (d: Link, i: Number) -> Node
            fun target(target: Node): Diagonal<Link, Node>
            fun target(target: (d: Link, i: Number) -> `T$56`): Diagonal<Link, Node>
            fun projection(): (d: Node, i: Number) -> Pair<Number, Number>
            fun projection(projection: (d: Node, i: Number) -> Pair<Number, Number>): Diagonal<Link, Node>
        }
        fun axis(): Axis = noImpl
        interface Axis {
            @nativeInvoke
            fun invoke(selection: Selection<Any>)
            @nativeInvoke
            fun invoke(selection: Transition<Any>)
            fun scale(): Any
            fun scale(scale: Any): Axis
            fun orient(): String
            fun orient(orientation: String): Axis
            fun ticks(): Array<Any>
            fun ticks(vararg args: Any): Axis
            fun tickValues(): Array<Any>
            fun tickValues(values: Array<Any>): Axis
            fun tickSize(): Number
            fun tickSize(size: Number): Axis
            fun tickSize(inner: Number, outer: Number): Axis
            fun innerTickSize(): Number
            fun innerTickSize(size: Number): Axis
            fun outerTickSize(): Number
            fun outerTickSize(size: Number): Axis
            fun tickPadding(): Number
            fun tickPadding(padding: Number): Axis
            fun tickFormat(): (t: Any) -> String
            fun tickFormat(format: (t: Any) -> String): Axis
            fun tickFormat(format: String): Axis
        }
        fun brush(): Brush<Any> = noImpl
        fun <T> brush(): Brush<T> = noImpl
        @native
        object brush {
            interface Scale {
                fun domain(): Array<Number>
                fun domain(domain: Array<Number>): Scale
                fun range(): Array<Number>
                fun range(range: Array<Number>): Scale
                val invert: ((y: Number) -> Number)? get() = noImpl
            }
        }
        interface Brush<T> {
            @nativeInvoke
            fun invoke(selection: Selection<T>)
            @nativeInvoke
            fun invoke(selection: Transition<T>)
            fun event(selection: Selection<T>)
            fun event(selection: Transition<T>)
            fun x(): brush.Scale
            fun x(x: brush.Scale): Brush<T>
            fun y(): brush.Scale
            fun y(y: brush.Scale): Brush<T>
            fun extent(): dynamic /* Pair<Number, Number> | Pair<Pair<Number, Number>, Pair<Number, Number>> */
            fun extent(extent: Pair<Number, Number>): Brush<T>
            fun extent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): Brush<T>
            fun clamp(): dynamic /* Boolean | Pair<Boolean, Boolean> */
            fun clamp(clamp: Boolean): Brush<T>
            fun clamp(clamp: Pair<Boolean, Boolean>): Brush<T>
            fun clear()
            fun empty(): Boolean
//            fun on(type: Any /* "brushstart" */): (datum: T, index: Number) -> Unit
//            fun on(type: Any /* "brush" */): (datum: T, index: Number) -> Unit
//            fun on(type: Any /* "brushend" */): (datum: T, index: Number) -> Unit
            fun on(type: String): (datum: T, index: Number) -> Unit
//            fun on(type: Any /* "brushstart" */, listener: (datum: T, index: Number) -> Unit): Brush<T>
//            fun on(type: Any /* "brush" */, listener: (datum: T, index: Number) -> Unit): Brush<T>
//            fun on(type: Any /* "brushend" */, listener: (datum: T, index: Number) -> Unit): Brush<T>
            fun on(type: String, listener: (datum: T, index: Number) -> Unit): Brush<T>
        }
    }
    fun xhr(url: String, mimeType: String? = null, callback: ((err: Any, data: Any) -> Unit)? = null): Xhr = noImpl
    fun xhr(url: String, callback: (err: Any, data: Any) -> Unit): Xhr = noImpl
    interface Xhr {
        fun header(name: String): String
        fun header(name: String, value: String): Xhr
        fun mimeType(): String
        fun mimeType(type: String): Xhr
        fun responseType(): String
        fun responseType(type: String): Xhr
        fun response(): (request: XMLHttpRequest) -> Any
        fun response(value: (request: XMLHttpRequest) -> Any): Xhr
        fun get(callback: ((err: Any, data: Any) -> Unit)? = null): Xhr
        fun post(data: Any? = null, callback: ((err: Any, data: Any) -> Unit)? = null): Xhr
        fun post(callback: (err: Any, data: Any) -> Unit): Xhr
        fun send(method: String, data: Any? = null, callback: ((err: Any, data: Any) -> Unit)? = null): Xhr
        fun send(method: String, callback: (err: Any, data: Any) -> Unit): Xhr
        fun abort(): Xhr
//        fun on(type: Any /* "beforesend" */): (request: XMLHttpRequest) -> Unit
//        fun on(type: Any /* "progress" */): (request: XMLHttpRequest) -> Unit
//        fun on(type: Any /* "load" */): (response: Any) -> Unit
//        fun on(type: Any /* "error" */): (err: Any) -> Unit
//        fun on(type: String): (vararg args: Any) -> Unit
//        fun on(type: Any /* "beforesend" */, listener: (request: XMLHttpRequest) -> Unit): Xhr
//        fun on(type: Any /* "progress" */, listener: (request: XMLHttpRequest) -> Unit): Xhr
//        fun on(type: Any /* "load" */, listener: (response: Any) -> Unit): Xhr
//        fun on(type: Any /* "error" */, listener: (err: Any) -> Unit): Xhr
//        fun on(type: String, listener: (vararg args: Any) -> Unit): Xhr
    }
    fun text(url: String, mimeType: String? = null, callback: ((err: Any, data: String) -> Unit)? = null): Xhr = noImpl
    fun text(url: String, callback: (err: Any, data: String) -> Unit): Xhr = noImpl
    fun json(url: String, callback: ((err: Any, data: Any) -> Unit)? = null): Xhr = noImpl
    fun xml(url: String, mimeType: String? = null, callback: ((err: Any, data: Any) -> Unit)? = null): Xhr = noImpl
    fun xml(url: String, callback: (err: Any, data: Any) -> Unit): Xhr = noImpl
    fun html(url: String, callback: ((err: Any, data: DocumentFragment) -> Unit)? = null): Xhr = noImpl
    var csv: Dsv = noImpl
    var tsv: Dsv = noImpl
    fun dsv(delimiter: String, mimeType: String): Dsv = noImpl
    interface `T$57` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$58` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$59` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$60` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$61` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$62` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$63` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$64` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface Dsv {
        @nativeInvoke
        fun invoke(url: String, callback: (rows: Array<`T$57`>) -> Unit): DsvXhr<`T$57`>
        @nativeInvoke
        fun invoke(url: String, callback: (error: Any, rows: Array<`T$58`>) -> Unit): DsvXhr<`T$58`>
        @nativeInvoke
        fun invoke(url: String): DsvXhr<`T$59`>
        @nativeInvoke
        fun <T> invoke(url: String, accessor: (row: `T$60`) -> T, callback: (rows: Array<T>) -> Unit): DsvXhr<T>
        @nativeInvoke
        fun <T> invoke(url: String, accessor: (row: `T$61`) -> T, callback: (error: Any, rows: Array<T>) -> Unit): DsvXhr<T>
        @nativeInvoke
        fun <T> invoke(url: String, accessor: (row: `T$62`) -> T): DsvXhr<T>
        fun parse(string: String): Array<`T$63`>
        fun <T> parse(string: String, accessor: (row: `T$64`, index: Number) -> T): Array<T>
        fun parseRows(string: String): Array<Array<String>>
        fun <T> parseRows(string: String, accessor: (row: Array<String>, index: Number) -> T): Array<T>
        fun format(rows: Array<Any>): String
        fun formatRows(rows: Array<Array<String>>): String
    }
    interface `T$65` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface `T$66` {
        @nativeGetter
        fun get(key: String): String?
        @nativeSetter
        fun set(key: String, value: String)
    }
    interface DsvXhr<T> : Xhr {
        fun row(): (row: `T$65`) -> T
        fun <U> row(accessor: (row: `T$66`) -> U): DsvXhr<U>
        override fun header(name: String): String
        override fun header(name: String, value: String): DsvXhr<T>
        override fun mimeType(): String
        override fun mimeType(type: String): DsvXhr<T>
        override fun responseType(): String
        override fun responseType(type: String): DsvXhr<T>
        override fun response(): (request: XMLHttpRequest) -> Any
        // TODO bug
//        fun response(value: (request: XMLHttpRequest) -> Any): DsvXhr<T>
        fun get(callback: ((err: XMLHttpRequest, data: Array<T>) -> Unit)? = null): DsvXhr<T>
        fun post(data: Any? = null, callback: ((err: XMLHttpRequest, data: Array<T>) -> Unit)? = null): DsvXhr<T>
        fun post(callback: (err: XMLHttpRequest, data: Array<T>) -> Unit): DsvXhr<T>
        fun send(method: String, data: Any? = null, callback: ((err: XMLHttpRequest, data: Array<T>) -> Unit)? = null): DsvXhr<T>
        fun send(method: String, callback: (err: XMLHttpRequest, data: Array<T>) -> Unit): DsvXhr<T>
        override fun abort(): DsvXhr<T>
//        override fun on(type: Any /* "beforesend" */): (request: XMLHttpRequest) -> Unit
//        override fun on(type: Any /* "progress" */): (request: XMLHttpRequest) -> Unit
//        override fun on(type: Any /* "load" */): (response: Array<T>) -> Unit
//        override fun on(type: Any /* "error" */): (err: Any) -> Unit
//        override fun on(type: String): (vararg args: Any) -> Unit
//        fun on(type: Any /* "beforesend" */, listener: (request: XMLHttpRequest) -> Unit): DsvXhr<T>
//        fun on(type: Any /* "progress" */, listener: (request: XMLHttpRequest) -> Unit): DsvXhr<T>
        fun on(type: Any /* "load" */, listener: (response: Array<T>) -> Unit): DsvXhr<T>
        fun on(type: Any /* "error" */, listener: (err: Any) -> Unit): DsvXhr<T>
//        fun on(type: String, listener: (vararg args: Any) -> Unit): DsvXhr<T>
    }
    fun locale(definition: LocaleDefinition): Locale = noImpl
    interface LocaleDefinition {
        var decimal: String
        var thousands: String
        var grouping: Array<Number>
        var currency: Pair<String, String>
        var dateTime: String
        var date: String
        var time: String
        var periods: Pair<String, String>
        var days: Array<String>
        var shortDays: Array<String>
        var months: Array<String>
        var shortMonths: Array<String>
    }
    interface `T$67` {
        @nativeInvoke
        fun invoke(specifier: String): time.Format
        fun utc(specifier: String): time.Format
        fun multi(formats: Array<Pair<String, (d: Date) -> dynamic /* Boolean | Number */>>): time.Format
    }
    interface Locale {
        fun numberFormat(specifier: String): (n: Number) -> String
        var timeFormat: `T$67`
    }
    @native
    object layout {
        fun bundle(): Bundle<bundle.Node> = noImpl
        fun <T : bundle.Node> bundle(): Bundle<T> = noImpl
        @native
        object bundle {
            interface Node {
                var parent: Node
            }
            interface Link<T : Node> {
                var source: T
                var target: T
            }
        }
        interface Bundle<T : bundle.Node> {
            @nativeInvoke
            fun invoke(links: Array<bundle.Link<T>>): Array<Array<T>>
        }
        fun chord(): Chord = noImpl
        @native
        object chord {
            interface Link {
                var source: Node
                var target: Node
            }
            interface Node {
                var index: Number
                var subindex: Number
                var startAngle: Number
                var endAngle: Number
                var value: Number
            }
            interface Group {
                var index: Number
                var startAngle: Number
                var endAngle: Number
                var value: Number
            }
        }
        interface Chord {
            fun matrix(): Array<Array<Number>>
            fun matrix(matrix: Array<Array<Number>>): Chord
            fun padding(): Number
            fun padding(padding: Number): Chord
            fun sortGroups(): (a: Number, b: Number) -> Number
            fun sortGroups(comparator: (a: Number, b: Number) -> Number): Chord
            fun sortSubgroups(): (a: Number, b: Number) -> Number
            fun sortSubgroups(comparator: (a: Number, b: Number) -> Number): Chord
            fun sortChords(): (a: Number, b: Number) -> Number
            fun sortChords(comparator: (a: Number, b: Number) -> Number): Chord
            fun chords(): Array<chord.Link>
            fun groups(): Array<chord.Group>
        }
        fun cluster(): Cluster<cluster.Result> = noImpl
        fun <T : cluster.Result> cluster(): Cluster<T> = noImpl
        @native
        object cluster {
            interface Result {
                var parent: Result? get() = noImpl; set(value){}
                var children: Array<Result>? get() = noImpl; set(value){}
                var depth: Number? get() = noImpl; set(value){}
                var x: Number? get() = noImpl; set(value){}
                var y: Number? get() = noImpl; set(value){}
            }
            interface Link<T : Result> {
                var source: T
                var target: T
            }
        }
        interface Cluster<T : cluster.Result> {
            @nativeInvoke
            fun invoke(root: T): Array<T>
            fun nodes(root: T): Array<T>
            fun links(nodes: Array<T>): Array<cluster.Link<T>>
            fun children(): (node: T) -> Array<T>
            fun children(accessor: (node: T) -> Array<T>): Cluster<T>
            fun sort(): (a: T, b: T) -> Number
            fun sort(comparator: (a: T, b: T) -> Number): Cluster<T>
            fun separation(): (a: T, b: T) -> Number
            fun separation(separation: (a: T, b: T) -> Number): Cluster<T>
            fun size(): Pair<Number, Number>
            fun size(size: Pair<Number, Number>): Cluster<T>
            fun nodeSize(): Pair<Number, Number>
            fun nodeSize(nodeSize: Pair<Number, Number>): Cluster<T>
            fun value(): (a: T) -> Number
            fun value(value: (a: T) -> Number): Cluster<T>
        }
        fun force(): Force<force.Link<force.Node>, force.Node> = noImpl
//        fun <Node : force.Node> force(): Force<force.Link<Node>, Node> = noImpl
        fun <Link : force.Link<force.Node>, Node : force.Node> force(): Force<Link, Node> = noImpl
        @native
        object force {
            interface Link<T : Node> {
                var source: T
                var target: T
            }
            interface Node {
                var index: Number? get() = noImpl; set(value){}
                var x: Number? get() = noImpl; set(value){}
                var y: Number? get() = noImpl; set(value){}
                var px: Number? get() = noImpl; set(value){}
                var py: Number? get() = noImpl; set(value){}
                var fixed: Boolean? get() = noImpl; set(value){}
                var weight: Number? get() = noImpl; set(value){}
            }
            interface Event {
                var type: String
                var alpha: Number
            }
        }
        interface `T$68` {
            var source: Number
            var target: Number
        }
        interface Force<Link : force.Link<force.Node>, Node : force.Node> {
            fun size(): Pair<Number, Number>
            fun size(size: Pair<Number, Number>): Force<Link, Node>
            fun linkDistance(): dynamic /* Number | (link: Link, index: Number) -> Number */
            fun linkDistance(distance: Number): Force<Link, Node>
            fun linkDistance(distance: (link: Link, index: Number) -> Number): Force<Link, Node>
            fun linkStrength(): dynamic /* Number | (link: Link, index: Number) -> Number */
            fun linkStrength(strength: Number): Force<Link, Node>
            fun linkStrength(strength: (link: Link, index: Number) -> Number): Force<Link, Node>
            fun friction(): Number
            fun friction(friction: Number): Force<Link, Node>
            fun charge(): dynamic /* Number | (node: Node, index: Number) -> Number */
            fun charge(charge: Number): Force<Link, Node>
            fun charge(charge: (node: Node, index: Number) -> Number): Force<Link, Node>
            fun chargeDistance(): Number
            fun chargeDistance(distance: Number): Force<Link, Node>
            fun theta(): Number
            fun theta(theta: Number): Force<Link, Node>
            fun gravity(): Number
            fun gravity(gravity: Number): Force<Link, Node>
            fun nodes(): Array<Node>
            fun nodes(nodes: Array<Node>): Force<Link, Node>
            fun links(): Array<Link>
            fun links(links: Array<`T$68`>): Force<Link, Node>
            fun links(links: Array<Link>): Force<Link, Node>
            fun start(): Force<Link, Node>
            fun tick(): Force<Link, Node>
            fun alpha(): Number
            fun alpha(value: Number): Force<Link, Node>
            fun resume(): Force<Link, Node>
            fun stop(): Force<Link, Node>
            fun on(type: String): (event: force.Event) -> Unit
            fun on(type: String, listener: (event: force.Event) -> Unit): Force<Link, Node>
            fun drag(): behavior.Drag<Node>
            fun drag(selection: Selection<Node>)
        }
        fun hierarchy(): Hierarchy<hierarchy.Result> = noImpl
        fun <T : hierarchy.Result> hierarchy(): Hierarchy<T> = noImpl
        @native
        object hierarchy {
            interface Result {
                var parent: Result? get() = noImpl; set(value){}
                var children: Array<Result>? get() = noImpl; set(value){}
                var value: Number? get() = noImpl; set(value){}
                var depth: Number? get() = noImpl; set(value){}
            }
        }
        interface Hierarchy<T : hierarchy.Result> {
            @nativeInvoke
            fun invoke(root: T): Array<T>
            fun children(): (node: T) -> Array<T>
            fun children(accessor: (node: T) -> Array<T>): Hierarchy<T>
            fun sort(): (a: T, b: T) -> Number
            fun sort(comparator: (a: T, b: T) -> Number): Hierarchy<T>
            fun value(): (node: T) -> Number
            fun value(accessor: (node: T) -> Number): Hierarchy<T>
            fun revalue(root: T): Array<T>
        }
        fun histogram(): Histogram<Number> = noImpl
        fun <T> histogram(): Histogram<T> = noImpl
        @native
        object histogram {
            interface Bin<T> : JsArray<T> {
                var x: Number
                var dx: Number
                var y: Number
            }
        }
        interface Histogram<T> {
            @nativeInvoke
            fun invoke(values: Array<T>, index: Number? = null): Array<histogram.Bin<T>>
            fun value(): (datum: T, index: Number) -> Number
            fun value(value: (datum: T, index: Number) -> Number): Histogram<T>
            fun range(): (values: Array<T>, index: Number) -> Pair<Number, Number>
            fun range(range: (values: Array<T>, index: Number) -> Pair<Number, Number>): Histogram<T>
            fun range(range: Pair<Number, Number>): Histogram<T>
            fun bins(): (range: Pair<Number, Number>, values: Array<T>, index: Number) -> Array<Number>
            fun bins(count: Number): Histogram<T>
            fun bins(thresholds: Array<Number>): Histogram<T>
            fun bins(func: (range: Pair<Number, Number>, values: Array<T>, index: Number) -> Array<Number>): Histogram<T>
            fun frequency(): Boolean
            fun frequency(frequency: Boolean): Histogram<T>
        }
        fun pack(): Pack<pack.Node> = noImpl
        fun <T : pack.Node> pack(): Pack<T> = noImpl
        @native
        object pack {
            interface Node {
                var parent: Node? get() = noImpl; set(value){}
                var children: Array<Node>? get() = noImpl; set(value){}
                var value: Number? get() = noImpl; set(value){}
                var depth: Number? get() = noImpl; set(value){}
                var x: Number? get() = noImpl; set(value){}
                var y: Number? get() = noImpl; set(value){}
                var r: Number? get() = noImpl; set(value){}
            }
            interface Link<T : Node> {
                var source: Node
                var target: Node
            }
        }
        interface Pack<T : pack.Node> {
            @nativeInvoke
            fun invoke(root: T): Array<T>
            fun nodes(root: T): Array<T>
            fun links(nodes: Array<T>): Array<pack.Link<T>>
            fun children(): (node: T, depth: Number) -> Array<T>
            fun children(children: (node: T, depth: Number) -> Array<T>): Pack<T>
            fun sort(): (a: T, b: T) -> Number
            fun sort(comparator: (a: T, b: T) -> Number): Pack<T>
            fun value(): (node: T) -> Number
            fun value(value: (node: T) -> Number): Pack<T>
            fun size(): Pair<Number, Number>
            fun size(size: Pair<Number, Number>): Pack<T>
            fun radius(): dynamic /* Number | (node: T) -> Number */
            fun radius(radius: Number): Pack<T>
            fun radius(radius: (node: T) -> Number): Pack<T>
            fun padding(): Number
            fun padding(padding: Number): Pack<T>
        }
        fun partition(): Partition<partition.Node> = noImpl
        fun <T : partition.Node> partition(): Partition<T> = noImpl
        @native
        object partition {
            interface Link<T : Node> {
                var source: T
                var target: T
            }
            interface Node {
                var parent: Node? get() = noImpl; set(value){}
                var children: Number? get() = noImpl; set(value){}
                var value: Number? get() = noImpl; set(value){}
                var depth: Number? get() = noImpl; set(value){}
                var x: Number? get() = noImpl; set(value){}
                var y: Number? get() = noImpl; set(value){}
                var dx: Number? get() = noImpl; set(value){}
                var dy: Number? get() = noImpl; set(value){}
            }
        }
        interface Partition<T : partition.Node> {
            @nativeInvoke
            fun invoke(root: T): Array<T>
            fun nodes(root: T): Array<T>
            fun links(nodes: Array<T>): Array<partition.Link<T>>
            fun children(): (node: T, depth: Number) -> Array<T>
            fun children(children: (node: T, depth: Number) -> Array<T>): Partition<T>
            fun sort(): (a: T, b: T) -> Number
            fun sort(comparator: (a: T, b: T) -> Number): Partition<T>
            fun value(): (node: T) -> Number
            fun value(value: (node: T) -> Number): Partition<T>
            fun size(): Pair<Number, Number>
            fun size(size: Pair<Number, Number>): Partition<T>
        }
        fun pie(): Pie<Number> = noImpl
        fun <T> pie(): Pie<T> = noImpl
        @native
        object pie {
            interface Arc<T> {
                var value: Number
                var startAngle: Number
                var endAngle: Number
                var padAngle: Number
                var data: T
            }
        }
        interface Pie<T> {
            @nativeInvoke
            fun invoke(data: Array<T>, index: Number? = null): Array<pie.Arc<T>>
            fun value(): (datum: T, index: Number) -> Number
            fun value(accessor: (datum: T, index: Number) -> Number): Pie<T>
            fun sort(): (a: T, b: T) -> Number
            fun sort(comparator: (a: T, b: T) -> Number): Pie<T>
            fun startAngle(): dynamic /* Number | (data: Array<T>, index: Number) -> Number */
            fun startAngle(angle: Number): Pie<T>
            fun startAngle(angle: (data: Array<T>, index: Number) -> Number): Pie<T>
            fun endAngle(): dynamic /* Number | (data: Array<T>, index: Number) -> Number */
            fun endAngle(angle: Number): Pie<T>
            fun endAngle(angle: (data: Array<T>, index: Number) -> Number): Pie<T>
            fun padAngle(): dynamic /* Number | (data: Array<T>, index: Number) -> Number */
            fun padAngle(angle: Number): Pie<T>
            fun padAngle(angle: (data: Array<T>, index: Number) -> Number): Pie<T>
        }
        fun stack(): Stack<Array<stack.Value>, stack.Value> = noImpl
//        fun <Value> stack(): Stack<Array<Value>, Value> = noImpl
        fun <Series, Value> stack(): Stack<Series, Value> = noImpl
        @native
        object stack {
            interface Value {
                var x: Number
                var y: Number
                var y0: Number? get() = noImpl; set(value){}
            }
        }
        interface Stack<Series, Value> {
            @nativeInvoke
            fun invoke(layers: Array<Series>, index: Number? = null): Array<Series>
            fun values(): (layer: Series, index: Number) -> Array<Value>
            fun values(accessor: (layer: Series, index: Number) -> Array<Value>): Stack<Series, Value>
            fun offset(): (data: Array<Pair<Number, Number>>) -> Array<Number>
//            fun offset(offset: Any /* "silhouette" */): Stack<Series, Value>
//            fun offset(offset: Any /* "wiggle" */): Stack<Series, Value>
//            fun offset(offset: Any /* "expand" */): Stack<Series, Value>
//            fun offset(offset: Any /* "zero" */): Stack<Series, Value>
            fun offset(offset: String): Stack<Series, Value>
            fun offset(offset: (data: Array<Pair<Number, Number>>) -> Array<Number>): Stack<Series, Value>
            fun order(): (data: Array<Pair<Number, Number>>) -> Array<Number>
//            fun order(order: Any /* "inside-out" */): Stack<Series, Value>
//            fun order(order: Any /* "reverse" */): Stack<Series, Value>
//            fun order(order: Any /* "default" */): Stack<Series, Value>
            fun order(order: String): Stack<Series, Value>
            fun order(order: (data: Array<Pair<Number, Number>>) -> Array<Number>): Stack<Series, Value>
            fun x(): (value: Value, index: Number) -> Number
            fun x(accessor: (value: Value, index: Number) -> Number): Stack<Series, Value>
            fun y(): (value: Value, index: Number) -> Number
            fun y(accesor: (value: Value, index: Number) -> Number): Stack<Series, Value>
            fun out(): (value: Value, y0: Number, y: Number) -> Unit
            fun out(setter: (value: Value, y0: Number, y: Number) -> Unit): Stack<Series, Value>
        }
        fun tree(): Tree<tree.Node> = noImpl
        fun <T : tree.Node> tree(): Tree<T> = noImpl
        @native
        object tree {
            interface Link<T : Node> {
                var source: T
                var target: T
            }
            interface Node {
                var parent: Node? get() = noImpl; set(value){}
                var children: Array<Node>? get() = noImpl; set(value){}
                var depth: Number? get() = noImpl; set(value){}
                var x: Number? get() = noImpl; set(value){}
                var y: Number? get() = noImpl; set(value){}
            }
        }
        interface Tree<T : tree.Node> {
            @nativeInvoke
            fun invoke(root: T, index: Number? = null): Array<T>
            fun nodes(root: T, index: Number? = null): Array<T>
            fun links(nodes: Array<T>): Array<tree.Link<T>>
            fun children(): (datum: T, index: Number) -> Array<T>
            fun children(children: (datum: T, index: Number) -> Array<T>): Tree<T>
            fun separation(): (a: T, b: T) -> Number
            fun separation(separation: (a: T, b: T) -> Number): Tree<T>
            fun size(): Pair<Number, Number>
            fun size(size: Pair<Number, Number>): Tree<T>
            fun nodeSize(): Pair<Number, Number>
            fun nodeSize(size: Pair<Number, Number>): Tree<T>
            fun sort(): (a: T, b: T) -> Number
            fun sort(comparator: (a: T, b: T) -> Number): Tree<T>
            fun value(): (datum: T, index: Number) -> Number
            fun value(value: (datum: T, index: Number) -> Number): Tree<T>
        }
        fun treemap(): Treemap<treemap.Node> = noImpl
        fun <T : treemap.Node> treemap(): Treemap<T> = noImpl
        @native
        object treemap {
            interface Node {
                var parent: Node? get() = noImpl; set(value){}
                var children: Array<Node>? get() = noImpl; set(value){}
                var value: Number? get() = noImpl; set(value){}
                var depth: Number? get() = noImpl; set(value){}
                var x: Number? get() = noImpl; set(value){}
                var y: Number? get() = noImpl; set(value){}
                var dx: Number? get() = noImpl; set(value){}
                var dy: Number? get() = noImpl; set(value){}
            }
            interface Link<T : Node> {
                var source: T
                var target: T
            }
        }
        interface Treemap<T : treemap.Node> {
            @nativeInvoke
            fun invoke(root: T, index: Number? = null): Array<T>
            fun nodes(root: T, index: Number? = null): Array<T>
            fun links(nodes: Array<T>): Array<treemap.Link<T>>
            fun children(): (node: T, depth: Number) -> Array<T>
            fun children(children: (node: T, depth: Number) -> Array<T>): Treemap<T>
            fun sort(): (a: T, b: T) -> Number
            fun sort(comparator: (a: T, b: T) -> Number): Treemap<T>
            fun value(): (node: T, index: Number) -> Number
            fun value(value: (node: T, index: Number) -> Number): Treemap<T>
            fun size(): Pair<Number, Number>
            fun size(size: Pair<Number, Number>): Treemap<T>
            fun padding(): (node: T, depth: Number) -> dynamic /* Padding = number | number[] */
            fun padding(padding: dynamic /* Padding = number | number[] */): Treemap<T>
            fun padding(padding: (node: T, depth: Number) -> dynamic /* Padding = number | number[] */): Treemap<T>
            fun round(): Boolean
            fun round(round: Boolean): Treemap<T>
            fun sticky(): Boolean
            fun sticky(sticky: Boolean): Boolean
            fun mode(): String
//            fun mode(mode: Any /* "squarify" */): Treemap<T>
//            fun mode(mode: Any /* "slice" */): Treemap<T>
//            fun mode(mode: Any /* "dice" */): Treemap<T>
//            fun mode(mode: Any /* "slice-dice" */): Treemap<T>
            fun mode(mode: String): Treemap<T>
            fun ratio(): Number
            fun ratio(ratio: Number): Treemap<T>
        }
    }
    @native
    object geom {
        fun voronoi(): Voronoi<Pair<Number, Number>> = noImpl
        fun <T> voronoi(): Voronoi<T> = noImpl
        @native
        object voronoi {
            interface Link<T> {
                var source: T
                var target: T
            }
        }
        interface Voronoi<T> {
            @nativeInvoke
            fun invoke(data: Array<T>): Array<Pair<Number, Number>>
            fun x(): (vertex: T) -> Number
            fun x(x: (vertex: T) -> Number): Voronoi<T>
            fun y(): (vertex: T) -> Number
            fun y(y: (vertex: T) -> Number): Voronoi<T>
            fun clipExtent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun clipExtent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): Voronoi<T>
            fun links(data: Array<T>): Array<voronoi.Link<T>>
            fun triangles(data: Array<T>): Array<Triple<T, T, T>>
        }
        fun delaunay(vertices: Array<Pair<Number, Number>>): Array<Pair<Pair<Number, Number>, Pair<Number, Number>>> = noImpl
        fun quadtree(): Quadtree<Pair<Number, Number>> = noImpl
        fun <T> quadtree(nodes: Array<T>, x1: Number? = null, y1: Number? = null, x2: Number? = null, y2: Number? = null): quadtree.Quadtree<T> = noImpl
        @native
        object quadtree {
            interface Node<T> {
                var nodes: Array<Node<T>>
                var leaf: Boolean
                var point: T
                var x: Number
                var y: Number
            }
            interface Quadtree<T> : Node<T> {
                fun add(point: T)
                fun visit(callback: (node: Node<T>, x1: Number, y1: Number, x2: Number, y2: Number) -> dynamic /* Boolean | Unit */)
                fun find(point: Pair<Number, Number>): T
            }
        }
        interface Quadtree<T> {
            @nativeInvoke
            fun invoke(points: Array<T>): quadtree.Quadtree<T>
            fun x(): (datum: T, index: Number) -> Number
            fun x(x: Number): Quadtree<T>
            fun x(x: (datum: T, index: Number) -> Number): Quadtree<T>
            fun y(): (datum: T, index: Number) -> Number
            fun y(y: Number): Quadtree<T>
            fun y(y: (datum: T, index: Number) -> Number): Quadtree<T>
            fun extent(): Pair<Pair<Number, Number>, Pair<Number, Number>>
            fun extent(extent: Pair<Pair<Number, Number>, Pair<Number, Number>>): Quadtree<T>
        }
        fun hull(vertices: Array<Pair<Number, Number>>): Array<Pair<Number, Number>> = noImpl
        fun hull(): Hull<Pair<Number, Number>> = noImpl
        fun <T> hull(): Hull<T> = noImpl
        interface Hull<T> {
            @nativeInvoke
            fun invoke(vertices: Array<T>): Array<Pair<Number, Number>>
            fun x(): (datum: T) -> Number
            fun x(x: (datum: T) -> Number): Hull<T>
            fun y(): (datum: T) -> Number
            fun y(y: (datum: T) -> Number): Hull<T>
        }
        fun polygon(vertices: Array<Pair<Number, Number>>): Polygon = noImpl
        interface Polygon {
            fun area(): Number
            fun centroid(): Pair<Number, Number>
            fun clip(subject: Array<Pair<Number, Number>>): Array<Pair<Number, Number>>
        }
    }
}
@native
interface TouchList
