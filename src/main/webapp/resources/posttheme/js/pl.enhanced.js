!function(e,a){"use strict";var l="placeholderEnhanced",s=a.createElement("input"),t=a.createElement("textarea"),n="placeholder"in s&&"placeholder"in t,r={FOCUS:"focus.placeholder",BLUR:"blur.placeholder"},o={cssClass:"placeholder",normalize:!0},c=e.fn.val,i=function(a){return e.nodeName(a,"input")||e.nodeName(a,"textarea")},d=function(a){for(var l,s=["placeholder","name","id"],t={},n=0,r=a.attributes.length;r>n;n++)l=a.attributes[n],l.specified&&e.inArray(l.name,s)<0&&(t[l.name]=l.value);return t},u=function(e){e.css({position:"",left:""})},p=function(e){e.css({position:"absolute",left:"-9999em"})};(!n||o.normalize)&&(n?n&&o.normalize&&(e.fn.val=function(){var a=arguments,s=this[0];return s?a.length?this.each(function(s,t){var n=e(t),r=e.data(t,l),o=t._placeholder;r&&o&&i(t)&&(a[0]||t.value===o?a[0]&&n.hasClass(r.cssClass)&&n.removeClass(r.cssClass):n.addClass(r.cssClass).attr("placeholder",o)),c.apply(n,a)}):c.apply(this,a):void 0}):e.fn.val=function(){var a,s=arguments,t=this[0];return t?s.length?this.each(function(a,t){var n=e(t),r=e.data(t,l),o=n.attr("placeholder");r&&o&&i(t)?s[0]||t.value===o?s[0]&&(n.hasClass(r.cssClass)&&n.removeClass(r.cssClass),c.apply(n,s)):t.value=n.addClass(r.cssClass).attr("placeholder"):c.apply(n,s)}):(a=e(t).attr("placeholder"),a&&i(t)?t.value===a?"":t.value:c.apply(this,s)):void 0},e.fn[l]=function(a){var s=e.extend(o,a);if(this.length&&(!n||s.normalize))return"destroy"===a?this.filter(function(a,s){return e.data(s,l)}).removeClass(s.cssClass).each(function(a,s){var t=e(s).unbind(".placeholder"),r="password"===s.type,o=t.attr("placeholder");n?delete s._placeholder:(s.value===o&&(s.value=""),r&&(u(t),t.prev().unbind(".placeholder").remove())),e.fn.val=c,e.removeData(s,l)}):this.each(function(a,t){if(!e.data(t,l)){e.data(t,l,s);var o=e(t),c="password"===t.type,i=o.attr("placeholder"),h=null,v=null,f=null;n?n&&s.normalize&&(t._placeholder=o.attr("placeholder"),v=function(){t.value||o.addClass(s.cssClass).attr("placeholder",i)},f=function(){o.removeAttr("placeholder").removeClass(s.cssClass)}):(v=function(){o.val()?o.val()&&c&&f():c?(u(h),p(o)):o.val(i).addClass(s.cssClass)},c?(f=function(){u(o),p(h)},h=e("<input>",e.extend(d(t),{type:"text",value:i,tabindex:-1})).addClass(s.cssClass).bind(r.FOCUS,function(){o.trigger(r.FOCUS)}).insertBefore(o)):f=function(){o.hasClass(s.cssClass)&&(t.value="",o.removeClass(s.cssClass))}),o.bind(r.BLUR,v).bind(r.FOCUS,f).trigger(r.BLUR)}})},e(function(){e("input[placeholder], textarea[placeholder]")[l]()}))}(jQuery,document);