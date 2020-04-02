(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["import-medicine-import-medicine-module"],{

/***/ "./node_modules/raw-loader/index.js!./src/app/pages/import-medicine/import-medicine.component.html":
/*!************************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/pages/import-medicine/import-medicine.component.html ***!
  \************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nb-card>\r\n    <nb-card-header>\r\n        Hóa đơn nhập thuốc\r\n    </nb-card-header>\r\n    <nb-card-body>\r\n        <!-- <nb-card>\r\n            <nb-card-header>Thông tin cơ bản</nb-card-header>\r\n            <nb-card-body>\r\n                <div class=\"row\">\r\n                    <div class=\"col-6 col-md-4\">\r\n                        \r\n                    </div>\r\n                    <div class=\"col-6 col-md-4\">\r\n                        <input nbInput placeholder=\"Ngày nhập thuốc\" [nbDatepicker]=\"formpicker\">\r\n                        <nb-datepicker #formpicker></nb-datepicker>\r\n                    </div> \r\n                    <div class=\"col-6 col-md-4\">\r\n                    </div>\r\n                </div>\r\n            </nb-card-body>\r\n        </nb-card> -->\r\n    </nb-card-body>\r\n    <nb-card-body>\r\n        <nb-card>\r\n            <nb-card-header>\r\n                <div class=\"row\">\r\n                    <div class=\"col-md-4\">\r\n                        Các loại thuốc\r\n                    </div>\r\n                    <div class=\"col-md-8\">\r\n                        <input [(ngModel)]=\"date\" nbInput placeholder=\"Ngày nhập thuốc\" [nbDatepicker]=\"formpicker\">\r\n                        <nb-datepicker #formpicker format=\"dd\\MM\\yyyy\"></nb-datepicker>\r\n                    </div>\r\n                </div>\r\n\r\n            </nb-card-header>\r\n            <nb-card-body>\r\n                <ng2-smart-table [settings]=\"settings\" [source]=\"source\" (deleteConfirm)=\"onDeleteConfirm($event)\"\r\n                    (edit)=\"onEditConfirm($event)\" (editConfirm)=\"onEditConfirm($event)\"\r\n                    (createConfirm)=\"onCreateConfirm($event)\">\r\n                </ng2-smart-table>\r\n            </nb-card-body> \r\n        </nb-card>\r\n\r\n    </nb-card-body>\r\n    <nb-card-footer>\r\n        <div class=\"row\">\r\n            <div class=\"col-md-11\"></div>\r\n            <div class=\"col-md-1\">\r\n                <!-- (click)=\"notifyBeforeCreate(dialog)\" -->\r\n                <button nbButton status=\"danger\" (click)=\"createOrder()\"> Tạo </button>\r\n            </div>\r\n        </div>\r\n    </nb-card-footer>\r\n</nb-card>\r\n<ng-template #dialog let-data let-ref=\"dialogRef\">\r\n    <nb-card>\r\n        <nb-card-header>Thông tin chi tiết\r\n        </nb-card-header>\r\n        <nb-card-body>\r\n            <ng2-smart-table [settings]=\"confirmCreateSetting\" [source]=\"source\">\r\n            </ng2-smart-table>\r\n        </nb-card-body>\r\n        <nb-card-footer>\r\n            <div class=\"row justify-content-md-center align-items-center\">\r\n                <div class=\"col-md-0 offset-md-0\">\r\n                    <button class=\"cancel\" status=\"danger\" nbButton (click)=\"ref.close()\">Hủy</button>\r\n                </div>\r\n                <div class=\"col-md-1 offset-md-0\">\r\n                    <button nbButton (click)=\"ref.close(true)\">Tạo</button>\r\n                </div>\r\n            </div>\r\n        </nb-card-footer>\r\n    </nb-card>\r\n</ng-template>"

/***/ }),

/***/ "./src/app/pages/import-medicine/import-medicine-routing.module.ts":
/*!*************************************************************************!*\
  !*** ./src/app/pages/import-medicine/import-medicine-routing.module.ts ***!
  \*************************************************************************/
/*! exports provided: ImportMedicineRoutingModule, routedComponents */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImportMedicineRoutingModule", function() { return ImportMedicineRoutingModule; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "routedComponents", function() { return routedComponents; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _import_medicine_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./import-medicine.component */ "./src/app/pages/import-medicine/import-medicine.component.ts");




const routes = [{
        path: '',
        component: _import_medicine_component__WEBPACK_IMPORTED_MODULE_3__["ImportMedicineComponent"],
        children: [
            {
                path: 'smart-table',
                component: _import_medicine_component__WEBPACK_IMPORTED_MODULE_3__["ImportMedicineComponent"],
            },
            {
                path: '**',
                redirectTo: '',
                pathMatch: 'full'
            }
        ],
    }];
let ImportMedicineRoutingModule = class ImportMedicineRoutingModule {
};
ImportMedicineRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
        exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]],
    })
], ImportMedicineRoutingModule);

const routedComponents = [];


/***/ }),

/***/ "./src/app/pages/import-medicine/import-medicine.component.scss":
/*!**********************************************************************!*\
  !*** ./src/app/pages/import-medicine/import-medicine.component.scss ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BhZ2VzL2ltcG9ydC1tZWRpY2luZS9pbXBvcnQtbWVkaWNpbmUuY29tcG9uZW50LnNjc3MifQ== */"

/***/ }),

/***/ "./src/app/pages/import-medicine/import-medicine.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/pages/import-medicine/import-medicine.component.ts ***!
  \********************************************************************/
/*! exports provided: ImportMedicineComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImportMedicineComponent", function() { return ImportMedicineComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _tables_tables_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../tables/tables.module */ "./src/app/pages/tables/tables.module.ts");
/* harmony import */ var ng2_smart_table__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ng2-smart-table */ "./node_modules/ng2-smart-table/index.js");
/* harmony import */ var _typescript_angular_client__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../typescript-angular-client */ "./src/typescript-angular-client/index.ts");
/* harmony import */ var _nebular_theme__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @nebular/theme */ "./node_modules/@nebular/theme/fesm2015/index.js");
/* harmony import */ var _sharedmodule_toast__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../sharedmodule/toast */ "./src/app/pages/sharedmodule/toast.ts");
/* harmony import */ var _log_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../log.service */ "./src/app/log.service.ts");








let ImportMedicineComponent = class ImportMedicineComponent {
    constructor(log, importMedicineControllerService, medicineControllerService, dialogService, toastService) {
        this.log = log;
        this.importMedicineControllerService = importMedicineControllerService;
        this.medicineControllerService = medicineControllerService;
        this.dialogService = dialogService;
        this.toastService = toastService;
        this.listMedicineDislay = [];
        this.listMedicines = [];
        this.source = new ng2_smart_table__WEBPACK_IMPORTED_MODULE_3__["LocalDataSource"]();
        this.date = new Date();
        this.data = [{}];
        this.customer = { id: null, name: '', phoneNumber: '', type: 'other' };
        this.confirmCreateSetting = {
            hideSubHeader: true,
            hideHeader: true,
            add: {
                addButtonContent: '',
                createButtonContent: '',
                cancelButtonContent: '',
                confirmCreate: false,
            },
            edit: {
                editButtonContent: '',
                saveButtonContent: '',
                cancelButtonContent: '',
                confirmSave: false,
            },
            delete: {
                deleteButtonContent: '',
                confirmDelete: false,
            },
            columns: {
                medicineCode: {
                    title: 'Mã thuốc',
                    editable: false,
                    addable: false,
                    filter: false,
                },
                amount: {
                    title: 'Số lượng',
                    editable: false,
                    addable: false,
                    filter: false,
                },
                medicineUnit: {
                    title: 'Đơn vị',
                    type: 'text',
                    editable: false,
                    addable: false,
                    filter: false,
                },
                // medicineName: {
                //   title: 'Tên thuốc',
                //   type: 'text',
                //   editable: false,
                //   addable: false,
                //   filter: false,
                // },
                // medicinePrice: {
                //   title: "Giá tiền",
                //   type: 'number',
                //   editable: false,
                //   addable: false,
                //   filter: false,
                // },
                total: {
                    title: 'Thành tiền',
                    type: 'text',
                    editable: false,
                    addable: false,
                    filter: false,
                },
            },
        };
        this.prePareListMedicineDisplay();
    }
    ngOnInit() {
    }
    prePareListMedicineDisplay() {
        this.medicineControllerService.getListAllMedicine().subscribe(data => {
            this.listMedicines = data;
            this.listMedicines.forEach(element => {
                this.listMedicineDislay.push({ value: element.code, title: element.name });
            });
            this.settings = this.loadTableSetting();
        }, error => { this.settings = this.loadTableSetting(); });
    }
    loadTableSetting() {
        return {
            action: {
                add: true,
                edit: true,
                delete: true,
                position: 'left',
            },
            add: {
                addButtonContent: '<i class="nb-plus"></i>',
                createButtonContent: '<i class="nb-checkmark"></i>',
                cancelButtonContent: '<i class="nb-close"></i>',
                confirmCreate: true,
            },
            edit: {
                editButtonContent: '<i class="nb-edit"></i>',
                saveButtonContent: '<i class="nb-checkmark"></i>',
                cancelButtonContent: '<i class="nb-close"></i>',
                confirmSave: true,
            },
            delete: {
                deleteButtonContent: '<i class="nb-trash"></i>',
                confirmDelete: true,
            },
            columns: {
                medicineCode: {
                    title: 'Mã thuốc',
                    type: 'string',
                    filter: false,
                    editor: {
                        type: 'list',
                        config: {
                            list: this.listMedicineDislay
                        }
                    }
                },
                amount: {
                    title: 'Số lượng',
                    type: 'number',
                    filter: false,
                },
                medicineUnit: {
                    title: 'Đơn vị',
                    type: 'text',
                    editable: false,
                    addable: false,
                    filter: false,
                },
                medicineName: {
                    title: 'Tên thuốc',
                    type: 'text',
                    editable: false,
                    addable: false,
                    filter: false,
                },
            },
        };
    }
    selectType(event) {
        // this.type = event.value
        this.customer.type = event;
        this.source.getAll().then(data => {
            data.forEach(e => {
                let medicine = this.listMedicines.find(m => m.code === e.medicineCode);
                if (this.customer.type === 'company') {
                    e.medicinePrice = medicine.priceForCompany;
                }
                else if (this.customer.type === 'farm') {
                    e.medicinePrice = medicine.priceForFarm;
                }
                else {
                    e.medicinePrice = medicine.priceForPersonal;
                }
                e.total = e.amount * e.medicinePrice;
            });
            this.source.load(data);
        });
    }
    notifyBeforeCreate(dialog) {
        this.log.log(this.date.toISOString());
        let message = this.validateWhenCreateOrder();
        if (message !== "ok") {
            // this.notify(message);
            this.toastService.notify(4, "Lỗi", message);
            return;
        }
        this.dialogService.open(dialog).onClose.subscribe(isOke => {
            if (isOke)
                this.createOrder();
        });
    }
    createOrder() {
        let importOrderDto = { id: null, importDate: this.date, listMedicineImport: [], staffName: 'dangnt' };
        this.source.getAll().then(data => {
            if (data.length === 0) {
                this.toastService.notify(4, "Lỗi", "Chưa có thuốc nào được nhập!");
                return;
            }
            //Map data from datasource to Dto
            data.forEach(e => {
                importOrderDto.listMedicineImport.push({
                    amount: e.amount,
                    code: e.medicineCode,
                    name: e.medicineName,
                    unit: e.medicineUnit,
                    priceForCompany: null,
                    priceForFarm: null,
                    priceForPersonal: null,
                    total: null,
                    addMore: 0
                });
            });
            this.importMedicineControllerService.createImportOrder(importOrderDto).subscribe(data => {
                this.resetData();
                this.toastService.notify(1, "Thành công", "Thêm thành công!");
            }, error => {
                this.toastService.notify(4, "Lỗi", error.error.message);
            });
        });
    }
    onDeleteConfirm(event) {
        if (window.confirm('Are you sure you want to delete?')) {
            event.confirm.resolve();
        }
        else {
            event.confirm.reject();
        }
    }
    onCreateConfirm(event) {
        this.editOrCreateNewMedicine(event);
    }
    onEditConfirm(event) {
        this.editOrCreateNewMedicine(event);
    }
    editOrCreateNewMedicine(event) {
        let validateMessage = this.validateRow(event.newData);
        if (validateMessage === "ok") {
            event.newData = this.updateInfoRow(event.newData);
            event.confirm.resolve(event.newData);
        }
        else {
            event.confirm.reject();
            this.notify(validateMessage);
        }
    }
    updateInfoRow(newData) {
        let medicine = this.listMedicines.find(e => e.code == newData.medicineCode);
        newData.medicineName = medicine.name;
        if (this.customer.type === 'company') {
            newData.medicinePrice = medicine.priceForCompany;
        }
        else if (this.customer.type === 'farm') {
            newData.medicinePrice = medicine.priceForFarm;
        }
        else {
            newData.medicinePrice = medicine.priceForPersonal;
        }
        newData.medicineUnit = medicine.unit;
        newData.total = (newData.medicinePrice * newData.amount).toString();
        return newData;
    }
    validateRow(newData) {
        let result = "ok";
        if (newData) {
            if (newData.medicineCode === '') {
                result = 'Chưa chọn loại thuốc!';
            }
            else if (!newData.amount.match(/^\d+$/) && !newData.amount.match(/^\d+\.\d+$/)) {
                result = "Số lượng không đúng!";
            }
            else if (newData.amount <= 0) {
                result = 'Số lượng cần phải > 0!';
            }
        }
        else {
            result = "Chưa điền đủ thông tin!";
        }
        return result;
    }
    validateWhenCreateOrder() {
        let result = "ok";
        let length = this.source.count();
        if (length === 0) {
            result = "Đơn hàng trống!";
        }
        return result;
    }
    notify(message) {
        // this.dialogService.open(DialogNamePromptComponent, {
        //   context: {
        //     message: message
        //   },
        // });
        alert(message);
    }
    resetData() {
        this.customer = {};
        this.source.load([]);
    }
};
ImportMedicineComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'ngx-import-medicine',
        template: __webpack_require__(/*! raw-loader!./import-medicine.component.html */ "./node_modules/raw-loader/index.js!./src/app/pages/import-medicine/import-medicine.component.html"),
        providers: [
            _tables_tables_module__WEBPACK_IMPORTED_MODULE_2__["TablesModule"],
            _typescript_angular_client__WEBPACK_IMPORTED_MODULE_4__["MedicineControllerService"], _nebular_theme__WEBPACK_IMPORTED_MODULE_5__["NbDialogService"], _sharedmodule_toast__WEBPACK_IMPORTED_MODULE_6__["ToastrService"]
        ],
        styles: [__webpack_require__(/*! ./import-medicine.component.scss */ "./src/app/pages/import-medicine/import-medicine.component.scss")]
    }),
    tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_log_service__WEBPACK_IMPORTED_MODULE_7__["Logger"],
        _typescript_angular_client__WEBPACK_IMPORTED_MODULE_4__["ImportMedicineControllerService"],
        _typescript_angular_client__WEBPACK_IMPORTED_MODULE_4__["MedicineControllerService"],
        _nebular_theme__WEBPACK_IMPORTED_MODULE_5__["NbDialogService"],
        _sharedmodule_toast__WEBPACK_IMPORTED_MODULE_6__["ToastrService"]])
], ImportMedicineComponent);



/***/ }),

/***/ "./src/app/pages/import-medicine/import-medicine.module.ts":
/*!*****************************************************************!*\
  !*** ./src/app/pages/import-medicine/import-medicine.module.ts ***!
  \*****************************************************************/
/*! exports provided: ImportMedicineModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImportMedicineModule", function() { return ImportMedicineModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _nebular_theme__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @nebular/theme */ "./node_modules/@nebular/theme/fesm2015/index.js");
/* harmony import */ var ng2_smart_table__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ng2-smart-table */ "./node_modules/ng2-smart-table/index.js");
/* harmony import */ var _theme_theme_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../@theme/theme.module */ "./src/app/@theme/theme.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _import_medicine_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./import-medicine.component */ "./src/app/pages/import-medicine/import-medicine.component.ts");
/* harmony import */ var _import_medicine_routing_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./import-medicine-routing.module */ "./src/app/pages/import-medicine/import-medicine-routing.module.ts");
/* harmony import */ var _typescript_angular_client__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../typescript-angular-client */ "./src/typescript-angular-client/index.ts");
/* harmony import */ var _sharedmodule_sharemodule_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../sharedmodule/sharemodule.module */ "./src/app/pages/sharedmodule/sharemodule.module.ts");
/* harmony import */ var _service_core2__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../service/core2 */ "./src/app/service/core2.ts");











// import { TablesRoutingModule, routedComponents } from './tables-routing.module';
let ImportMedicineModule = class ImportMedicineModule {
};
ImportMedicineModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        imports: [
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbCardModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbTreeGridModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbIconModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbUserModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbCheckboxModule"],
            _theme_theme_module__WEBPACK_IMPORTED_MODULE_4__["ThemeModule"],
            ng2_smart_table__WEBPACK_IMPORTED_MODULE_3__["Ng2SmartTableModule"],
            _import_medicine_routing_module__WEBPACK_IMPORTED_MODULE_7__["ImportMedicineRoutingModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbButtonModule"],
            // ngFormsModule
            _sharedmodule_sharemodule_module__WEBPACK_IMPORTED_MODULE_9__["SharedModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbActionsModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbCheckboxModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbRadioModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbDatepickerModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbSelectModule"],
            _nebular_theme__WEBPACK_IMPORTED_MODULE_2__["NbIconModule"],
            _service_core2__WEBPACK_IMPORTED_MODULE_10__["MyCoreModule"],
        ],
        declarations: [
            _import_medicine_component__WEBPACK_IMPORTED_MODULE_6__["ImportMedicineComponent"],
        ],
        entryComponents: [],
        providers: [_typescript_angular_client__WEBPACK_IMPORTED_MODULE_8__["ImportMedicineControllerService"]]
    })
], ImportMedicineModule);



/***/ })

}]);
//# sourceMappingURL=import-medicine-import-medicine-module-es2015.js.map