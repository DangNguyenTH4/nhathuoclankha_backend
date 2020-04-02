(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["auth-auth-auth-module"],{

/***/ "./node_modules/raw-loader/index.js!./src/app/auth/auth/login/login.component.html":
/*!********************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/auth/auth/login/login.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1 id=\"title\" class=\"title\">Đăng nhập</h1>\r\n<p class=\"sub-title\">Xin chào! Hãy đăng nhập để tiếp tục.</p>\r\n\r\n<nb-alert *ngIf=\"showMessages.error && errors?.length && !submitted\" outline=\"danger\" role=\"alert\">\r\n  <p class=\"alert-title\"><b>Oh snap!</b></p>\r\n  <ul class=\"alert-message-list\">\r\n    <li *ngFor=\"let error of errors\" class=\"alert-message\">{{ error }}</li>\r\n  </ul>\r\n</nb-alert>\r\n\r\n<nb-alert *ngIf=\"showMessages.success && messages?.length && !submitted\" outline=\"success\" role=\"alert\">\r\n  <p class=\"alert-title\"><b>Hooray!</b></p>\r\n  <ul class=\"alert-message-list\">\r\n    <li *ngFor=\"let message of messages\" class=\"alert-message\">{{ message }}</li>\r\n  </ul>\r\n</nb-alert>\r\n\r\n<form (ngSubmit)=\"login()\" #form=\"ngForm\" aria-labelledby=\"title\">\r\n\r\n  <div class=\"form-control-group\">\r\n    <label class=\"label\" for=\"username\">Tài khoản:</label>\r\n    <input type=\"text\"\r\n     nbInput \r\n     placeholder=\"Tài khoản\" \r\n     style=\"width:100%\" \r\n     [(ngModel)]=\"user.username\"\r\n     name=\"username\" \r\n     id=\"username\"\r\n     fullWidth\r\n     autofocus\r\n     >\r\n\r\n  </div>\r\n\r\n  <div class=\"form-control-group\">\r\n    <label class=\"label\" for=\"input-password\">Mật khẩu:</label>\r\n    <input nbInput\r\n           fullWidth\r\n           [(ngModel)]=\"user.password\"\r\n           #password=\"ngModel\"\r\n           name=\"password\"\r\n           type=\"password\"\r\n           id=\"input-password\"\r\n           placeholder=\"Password\"\r\n           [status]=\"password.dirty ? (password.invalid  ? 'danger' : 'success') : ''\"\r\n           [required]=\"getConfigValue('forms.validation.password.required')\"\r\n           [minlength]=\"getConfigValue('forms.validation.password.minLength')\"\r\n           [maxlength]=\"getConfigValue('forms.validation.password.maxLength')\"\r\n           [attr.aria-invalid]=\"password.invalid && password.touched ? true : null\">\r\n    <ng-container *ngIf=\"password.invalid && password.touched \">\r\n      <p class=\"error-message\" *ngIf=\"password.errors?.required\">\r\n        Chưa nhập mật khẩu!\r\n      </p>\r\n      <p class=\"error-message\" *ngIf=\"password.errors?.minlength || password.errors?.maxlength\">\r\n        Mật khẩu phải\r\n        từ {{ getConfigValue('forms.validation.password.minLength') }}\r\n        tới {{ getConfigValue('forms.validation.password.maxLength') }}\r\n        kí tự\r\n      </p>\r\n    </ng-container>\r\n  </div>\r\n\r\n  <div class=\"form-control-group accept-group\">\r\n    <nb-checkbox name=\"rememberMe\" [(ngModel)]=\"user.rememberMe\" *ngIf=\"rememberMe\">Nhớ tài khoản</nb-checkbox>\r\n    <a class=\"forgot-password\" routerLink=\"../request-password\">Quên mật khẩu!</a>\r\n  </div>\r\n\r\n  <button nbButton\r\n          fullWidth\r\n          status=\"success\"\r\n          [disabled]=\"submitted || !form.valid\"\r\n          [class.btn-pulse]=\"submitted\">\r\n    Đăng nhập\r\n  </button>\r\n</form>\r\n\r\n\r\n<!-- <section class=\"another-action\" aria-label=\"Register\">\r\n  Nếu bạn chưa có tài khoản? <a class=\"text-link\" routerLink=\"../register\">Kế</a>\r\n</section> -->"

/***/ }),

/***/ "./src/app/auth/auth/auth-routing.module.ts":
/*!**************************************************!*\
  !*** ./src/app/auth/auth/auth-routing.module.ts ***!
  \**************************************************/
/*! exports provided: routes, AuthModuleRouting */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "routes", function() { return routes; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthModuleRouting", function() { return AuthModuleRouting; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _nebular_auth__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @nebular/auth */ "./node_modules/@nebular/auth/fesm5/index.js");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./login/login.component */ "./src/app/auth/auth/login/login.component.ts");





var routes = [
    {
        path: '',
        component: _nebular_auth__WEBPACK_IMPORTED_MODULE_3__["NbAuthComponent"],
        children: [
            {
                path: 'login',
                component: _login_login_component__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"],
            },
        ],
    },
];
var AuthModuleRouting = /** @class */ (function () {
    function AuthModuleRouting() {
    }
    AuthModuleRouting = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]],
        })
    ], AuthModuleRouting);
    return AuthModuleRouting;
}());



/***/ }),

/***/ "./src/app/auth/auth/auth.module.ts":
/*!******************************************!*\
  !*** ./src/app/auth/auth/auth.module.ts ***!
  \******************************************/
/*! exports provided: AuthModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthModule", function() { return AuthModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _nebular_theme__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @nebular/theme */ "./node_modules/@nebular/theme/fesm5/index.js");
/* harmony import */ var _nebular_auth__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @nebular/auth */ "./node_modules/@nebular/auth/fesm5/index.js");
/* harmony import */ var _auth_routing_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./auth-routing.module */ "./src/app/auth/auth/auth-routing.module.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./login/login.component */ "./src/app/auth/auth/login/login.component.ts");
/* harmony import */ var _service_auth_service_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../service/auth-service.service */ "./src/app/service/auth-service.service.ts");
/* harmony import */ var _service_core2__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../service/core2 */ "./src/app/service/core2.ts");











var AuthModule = /** @class */ (function () {
    function AuthModule() {
    }
    AuthModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"],
                _nebular_theme__WEBPACK_IMPORTED_MODULE_5__["NbAlertModule"],
                _nebular_theme__WEBPACK_IMPORTED_MODULE_5__["NbInputModule"],
                _nebular_theme__WEBPACK_IMPORTED_MODULE_5__["NbButtonModule"],
                _nebular_theme__WEBPACK_IMPORTED_MODULE_5__["NbCheckboxModule"],
                _auth_routing_module__WEBPACK_IMPORTED_MODULE_7__["AuthModuleRouting"],
                _nebular_auth__WEBPACK_IMPORTED_MODULE_6__["NbAuthModule"],
                _service_core2__WEBPACK_IMPORTED_MODULE_10__["MyCoreModule"],
            ],
            declarations: [
                _login_login_component__WEBPACK_IMPORTED_MODULE_8__["LoginComponent"]
            ],
            providers: [_service_auth_service_service__WEBPACK_IMPORTED_MODULE_9__["AuthService"]]
        })
    ], AuthModule);
    return AuthModule;
}());



/***/ }),

/***/ "./src/app/auth/auth/login/login.component.scss":
/*!******************************************************!*\
  !*** ./src/app/auth/auth/login/login.component.scss ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2F1dGgvYXV0aC9sb2dpbi9sb2dpbi5jb21wb25lbnQuc2NzcyJ9 */"

/***/ }),

/***/ "./src/app/auth/auth/login/login.component.ts":
/*!****************************************************!*\
  !*** ./src/app/auth/auth/login/login.component.ts ***!
  \****************************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _nebular_auth__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @nebular/auth */ "./node_modules/@nebular/auth/fesm5/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _service_auth_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../service/auth-service.service */ "./src/app/service/auth-service.service.ts");
/* harmony import */ var _service_tokenstorage_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../service/tokenstorage.service */ "./src/app/service/tokenstorage.service.ts");
/* harmony import */ var _typescript_angular_client__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../../typescript-angular-client */ "./src/typescript-angular-client/index.ts");
/* harmony import */ var _log_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../log.service */ "./src/app/log.service.ts");








var LoginComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](LoginComponent, _super);
    function LoginComponent(log, customerControllerService, authService, tokenStorageService, nbAuthServe, options, cd, router) {
        var _this = _super.call(this, nbAuthServe, options, cd, router) || this;
        _this.log = log;
        _this.customerControllerService = customerControllerService;
        _this.authService = authService;
        _this.tokenStorageService = tokenStorageService;
        _this.nbAuthServe = nbAuthServe;
        _this.isLoggedIn = false;
        _this.isLoginFailed = false;
        _this.roles = [];
        return _this;
    }
    LoginComponent.prototype.login = function () {
        this.log.log(this.user);
        var loginTrue = this.authService.login(this.user);
        this.log.logAny(loginTrue);
        this.router.navigate(["/store"]);
    };
    LoginComponent.prototype.ngOnInit = function () {
        if (this.authService.isAuthenticated()) {
            this.isLoggedIn = true;
        }
    };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'ngx-login',
            template: __webpack_require__(/*! raw-loader!./login.component.html */ "./node_modules/raw-loader/index.js!./src/app/auth/auth/login/login.component.html"),
            providers: [_service_auth_service_service__WEBPACK_IMPORTED_MODULE_4__["AuthService"], _typescript_angular_client__WEBPACK_IMPORTED_MODULE_6__["CustomerControllerService"]],
            styles: [__webpack_require__(/*! ./login.component.scss */ "./src/app/auth/auth/login/login.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](5, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_nebular_auth__WEBPACK_IMPORTED_MODULE_2__["NB_AUTH_OPTIONS"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_log_service__WEBPACK_IMPORTED_MODULE_7__["Logger"],
            _typescript_angular_client__WEBPACK_IMPORTED_MODULE_6__["CustomerControllerService"],
            _service_auth_service_service__WEBPACK_IMPORTED_MODULE_4__["AuthService"], _service_tokenstorage_service__WEBPACK_IMPORTED_MODULE_5__["TokenStorageService"],
            _nebular_auth__WEBPACK_IMPORTED_MODULE_2__["NbAuthService"], Object, _angular_core__WEBPACK_IMPORTED_MODULE_1__["ChangeDetectorRef"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], LoginComponent);
    return LoginComponent;
}(_nebular_auth__WEBPACK_IMPORTED_MODULE_2__["NbLoginComponent"]));



/***/ }),

/***/ "./src/app/service/core2.ts":
/*!**********************************!*\
  !*** ./src/app/service/core2.ts ***!
  \**********************************/
/*! exports provided: MyCoreModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MyCoreModule", function() { return MyCoreModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _jwt_interceptor_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./jwt.interceptor.service */ "./src/app/service/jwt.interceptor.service.ts");





var MyCoreModule = /** @class */ (function () {
    function MyCoreModule() {
    }
    MyCoreModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClientModule"]
            ],
            declarations: [],
            providers: [
                {
                    provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HTTP_INTERCEPTORS"],
                    useClass: _jwt_interceptor_service__WEBPACK_IMPORTED_MODULE_4__["JwtInterceptorService"],
                    multi: true,
                }, _jwt_interceptor_service__WEBPACK_IMPORTED_MODULE_4__["JwtInterceptorService"]
            ]
        })
    ], MyCoreModule);
    return MyCoreModule;
}());



/***/ }),

/***/ "./src/app/service/jwt.interceptor.service.ts":
/*!****************************************************!*\
  !*** ./src/app/service/jwt.interceptor.service.ts ***!
  \****************************************************/
/*! exports provided: JwtInterceptorService, authInterceptorProviders */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JwtInterceptorService", function() { return JwtInterceptorService; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "authInterceptorProviders", function() { return authInterceptorProviders; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _tokenstorage_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./tokenstorage.service */ "./src/app/service/tokenstorage.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _log_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../log.service */ "./src/app/log.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _pages_sharedmodule_toast__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../pages/sharedmodule/toast */ "./src/app/pages/sharedmodule/toast.ts");









var TOKEN_HEADER_KEY = 'Authorization';
var CONTENTTYPE = 'Content-Type';
var ACCEPT = 'Accept';
var APPJSON = 'application/json';
var JwtInterceptorService = /** @class */ (function () {
    function JwtInterceptorService(token, log, router, toast) {
        this.token = token;
        this.log = log;
        this.router = router;
        this.toast = toast;
    }
    JwtInterceptorService.prototype.intercept = function (req, next) {
        var _this = this;
        var token = this.token.getToken();
        if (!req.headers.has(CONTENTTYPE)) {
            req = req.clone({ setHeaders: { 'Content-Type': 'application/json' } });
        }
        if (!req.headers.has(ACCEPT)) {
            req = req.clone({ setHeaders: { 'Accept': 'application/json' } });
        }
        if (token !== null) {
            req = req.clone({ setHeaders: { 'Authorization': 'Bearer ' + token } });
        }
        return next.handle(req).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["catchError"])(function (error) {
            if (error instanceof _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpErrorResponse"]) {
                switch (error.status) {
                    case 400:
                        console.log(400);
                        return rxjs__WEBPACK_IMPORTED_MODULE_3__["Observable"].throw(error);
                    case 401:
                        console.log(401);
                        _this.token.clear();
                        _this.router.navigate(['auth/login']);
                        return rxjs__WEBPACK_IMPORTED_MODULE_3__["Observable"].throw(error);
                    case 403:
                        console.log(403);
                        _this.toast.notify(4, "Quyền", "Bạn không có quyền truy cập.");
                        return rxjs__WEBPACK_IMPORTED_MODULE_3__["Observable"].throw(error);
                    case 500:
                        _this.toast.notify(4, "Lỗi", error.error.message);
                }
            }
            else {
            }
        }));
    };
    /**
     * manage errors
     * @param err
     * @returns {any}
     */
    JwtInterceptorService.prototype.handleAuthError = function (err) {
        //handle your auth error or rethrow
        if (err.status === 401) {
            //navigate /delete cookies or whatever
            console.log('handled error ' + err.status);
            this.router.navigate(['auth/login']);
            // if you've caught / handled the error, you don't want to rethrow it unless you also want downstream consumers to have to handle it as well.
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(err.message);
        }
        throw err;
    };
    JwtInterceptorService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_tokenstorage_service__WEBPACK_IMPORTED_MODULE_4__["TokenStorageService"],
            _log_service__WEBPACK_IMPORTED_MODULE_6__["Logger"],
            _angular_router__WEBPACK_IMPORTED_MODULE_7__["Router"],
            _pages_sharedmodule_toast__WEBPACK_IMPORTED_MODULE_8__["ToastrService"]])
    ], JwtInterceptorService);
    return JwtInterceptorService;
}());

var authInterceptorProviders = [
    { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HTTP_INTERCEPTORS"], useClass: JwtInterceptorService, multi: true }
];


/***/ })

}]);
//# sourceMappingURL=auth-auth-auth-module-es5.js.map