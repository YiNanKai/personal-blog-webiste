/*只显示有确切权限的div界面*/
Vue.component('single-permission', {
	props: ['level','threshold'],
	template: '<div v-if="level === threshold"><slot>权限组件</slot></div>'
});
/*显示权限以上的所有div界面*/
Vue.component('permission', {
	props: ['level','threshold'],
	template: '<div v-if="level >= threshold"><slot>权限组件</slot></div>'
});

var app = new Vue({
  el: '#per',
  data: {
	threshold : 0,
	visible: false,
	userplaceholder: '用户名或邮箱',
	passwordplaceholder: '密码'
  },
  
  methods: {
	getThreshold: function () {
		return 13;
	}
 }
 
})