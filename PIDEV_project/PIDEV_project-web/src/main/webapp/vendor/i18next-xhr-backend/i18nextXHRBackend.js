! function(t, e) {
    "object" == typeof exports && "undefined" != typeof module ? module.exports = e() : "function" == typeof define && define.amd ? define(e) : t.i18nextXHRBackend = e()
}(this, function() {
    "use strict";
    var t = [],
        o = t.forEach,
        i = t.slice;
    var l = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function(t) {
        return typeof t
    } : function(t) {
        return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
    };

    function c(t, e) {
        if (e && "object" === (void 0 === e ? "undefined" : l(e))) {
            var n = "",
                o = encodeURIComponent;
            for (var i in e) n += "&" + o(i) + "=" + o(e[i]);
            if (!n) return t;
            t = t + (-1 !== t.indexOf("?") ? "&" : "?") + n.slice(1)
        }
        return t
    }

    function a(t, e, n, o, i) {
        o && "object" === (void 0 === o ? "undefined" : l(o)) && (i || (o._t = new Date), o = c("", o).slice(1)), e.queryStringParams && (t = c(t, e.queryStringParams));
        try {
            var a;
            (a = XMLHttpRequest ? new XMLHttpRequest : new ActiveXObject("MSXML2.XMLHTTP.3.0")).open(o ? "POST" : "GET", t, 1), e.crossDomain || a.setRequestHeader("X-Requested-With", "XMLHttpRequest"), a.withCredentials = !!e.withCredentials, o && a.setRequestHeader("Content-type", "application/x-www-form-urlencoded"), a.overrideMimeType && a.overrideMimeType("application/json");
            var r = e.customHeaders;
            if (r)
                for (var s in r) a.setRequestHeader(s, r[s]);
            a.onreadystatechange = function() {
                3 < a.readyState && n && n(a.responseText, a)
            }, a.send(o)
        } catch (t) {
            console && console.log(t)
        }
    }

    function r(t, e) {
        for (var n = 0; n < e.length; n++) {
            var o = e[n];
            o.enumerable = o.enumerable || !1, o.configurable = !0, "value" in o && (o.writable = !0), Object.defineProperty(t, o.key, o)
        }
    }
    var e = (function(t, e, n) {
        return e && r(t.prototype, e), n && r(t, n), t
    }(n, [{
        key: "init",
        value: function(t, e) {
            var n = 1 < arguments.length && void 0 !== e ? e : {};
            this.services = t, this.options = function(n) {
                return o.call(i.call(arguments, 1), function(t) {
                    if (t)
                        for (var e in t) void 0 === n[e] && (n[e] = t[e])
                }), n
            }(n, this.options || {}, {
                loadPath: "/locales/{{lng}}/{{ns}}.json",
                addPath: "/locales/add/{{lng}}/{{ns}}",
                allowMultiLoading: !1,
                parse: JSON.parse,
                crossDomain: !1,
                ajax: a
            })
        }
    }, {
        key: "readMulti",
        value: function(t, e, n) {
            var o = this.options.loadPath;
            "function" == typeof this.options.loadPath && (o = this.options.loadPath(t, e));
            var i = this.services.interpolator.interpolate(o, {
                lng: t.join("+"),
                ns: e.join("+")
            });
            this.loadUrl(i, n)
        }
    }, {
        key: "read",
        value: function(t, e, n) {
            var o = this.options.loadPath;
            "function" == typeof this.options.loadPath && (o = this.options.loadPath([t], [e]));
            var i = this.services.interpolator.interpolate(o, {
                lng: t,
                ns: e
            });
            this.loadUrl(i, n)
        }
    }, {
        key: "loadUrl",
        value: function(i, a) {
            var r = this;
            this.options.ajax(i, this.options, function(t, e) {
                if (500 <= e.status && e.status < 600) return a("failed loading " + i, !0);
                if (400 <= e.status && e.status < 500) return a("failed loading " + i, !1);
                var n = void 0,
                    o = void 0;
                try {
                    n = r.options.parse(t, i)
                } catch (t) {
                    o = "failed parsing " + i + " to json"
                }
                if (o) return a(o, !1);
                a(null, n)
            })
        }
    }, {
        key: "create",
        value: function(t, n, e, o) {
            var i = this;
            "string" == typeof t && (t = [t]);
            var a = {};
            a[e] = o || "", t.forEach(function(t) {
                var e = i.services.interpolator.interpolate(i.options.addPath, {
                    lng: t,
                    ns: n
                });
                i.options.ajax(e, i.options, function(t, e) {}, a)
            })
        }
    }]), n);

    function n(t) {
        var e = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : {};
        ! function(t, e) {
            if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
        }(this, n), this.init(t, e), this.type = "backend"
    }
    return e.type = "backend", e
});