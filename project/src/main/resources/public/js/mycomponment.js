/*登录组件，需要配合相关的css使用*/
Vue.component('login-form', {
	props: ['userplaceholder','passwordplaceholder'],
	template: '\
		<div class="logincontainer" id="login">\
			<section class="main" id="loginform">\
				<form class="form-1">\
					<p class="field">\
						<input type="text" name="login" :placeholder="userplaceholder">\
						<i class="icon-user icon-large"></i>\
					</p>\
					<p class="field">\
						<input type="password" name="password" :placeholder="passwordplaceholder">\
						<i class="icon-lock icon-large"></i>\
					</p>\
					<p class="submit">\
						<button type="submit" name="submit">\
							<i class="icon-arrow-right icon-large"></i>\
						</button>\
					</p>\
				</form>\
			</section>\
		</div>\
	          ',		
});

/*Vue.component('login-form', {
	props: ['userplaceholder','passwordplaceholder'],
	data() {
		return {
			loginInformation:{
				username:'',
				password:''
			}
		}
	},
	template: '\
		<div class="container" id="login">\
			<section class="main" id="loginform">\
				<el-form :model="loginInformation" ref="loginInformation" label-width="100px">\
					<p class="field">\
					    <el-form-item label="账户" prop="username" :rules="[\
							{ required: true, message: "给自己取个名吧"},\
							{ min: 3, max: 20, message: "长度在 3 到 20 个字符"}\
						]">\
						<el-input v-model="loginInformation.username" auto-complete="off" :placeholder="userplaceholder"></el-input>\
						</el-form-item>\
						<i class="icon-user icon-large"></i>\
					</p>\
					<p class="field">\
						<el-form-item label="密码" prop="password" :rules="[\
							{ required: true, message: "给自己取个名吧"},\
							{ min: 3, max: 20, message: "长度在 3 到 20 个字符"}\
						]">\
						<el-input type="password "v-model="loginInformation.password" auto-complete="off" :placeholder="passwordplaceholder"></el-input>\
						</el-form-item>\
						<i class="icon-lock icon-large"></i>\
					</p>\
					<p class="submit">\
						<button type="submit" name="submit">\
							<i class="icon-arrow-right icon-large"></i>\
						</button>\
					</p>\
				</el-form>\
			</section>\
		</div>\
	          ',		
});*/