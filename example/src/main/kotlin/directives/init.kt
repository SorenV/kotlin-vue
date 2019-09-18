package directives

import external.vue.Vue

fun initDirectives() {
    Vue.directive("on-external-click", onExternalClick)
}
