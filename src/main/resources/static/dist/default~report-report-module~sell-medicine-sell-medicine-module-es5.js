(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["default~report-report-module~sell-medicine-sell-medicine-module"],{

/***/ "./node_modules/raw-loader/index.js!./src/app/pages/sell-medicine/invoice/invoice.component.html":
/*!**********************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/pages/sell-medicine/invoice/invoice.component.html ***!
  \**********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n\t<p style=\"text-align: center;font-size: 13px;margin-bottom: 5px;\">\r\n\t<b>ĐẠI LÝ THUỐC THÚ Y LAN KHA</b>\r\n\t</p>\r\n\t<p style=\"text-align: center;font-size: 12px;margin-bottom: 5px;\">\r\n\t\tChuyên: <b>Bán buôn - Bán lẻ thuốc thú y và vaccine các loại</b>\r\n\t\t<br>\r\n\t\tĐịa chỉ: TDP4 - Tân Sơn - Lương Sơn - Thành Phố Sông Công\r\n\t\t<br>\r\n\t\tĐT+Zalo: KSCN Kha: <b>0399397831</b> - BSTY Lan: <b>0974525835 </b>\r\n\t\t\r\n\t</p>\r\n\t<p style=\"text-align: center;margin-bottom: 5px;\"><b>HÓA ĐƠN THANH TOÁN</b></p>\r\n\t\r\n</div>\r\n\r\n<div class=\"for\">\r\n\tTên khách hàng: {{customer.name}}\r\n\t<br>\r\n\tTên chủ trại  : {{customer.traiDungThuoc}}\r\n\t<br>\r\n</div>\r\n\r\n<div class=\"items\">\r\n\t<kendo-grid [data]=\"data\" scrollable=\"none\">\r\n\t\t<kendo-grid-column [style]=\"{'border-bottom':'1px solid black'}\" field=\"productName\" title=\"Mã sản phẩm\"\r\n\t\t\twidth=\"30%\">\r\n\t\t\t<ng-template kendoGridFooterTemplate>\r\n\t\t\t\tTổng cộng:\r\n\t\t\t</ng-template>\r\n\t\t</kendo-grid-column>\r\n\t\t<kendo-grid-column [style]=\"{'border-bottom':'1px solid black'}\" \t field=\"formatNumber\" title=\"Đơn giá(vnđ)\"\r\n\t\t\twidth=\"30%\" >\r\n\t\t</kendo-grid-column>\r\n\t\t<kendo-grid-column [style]=\"{'border-bottom':'1px solid black'}\" field=\"amountColumn\" title=\"Số lượng\"\r\n\t\t\twidth=\"10%\"  >\r\n\t\t\t<!-- <ng-template kendoGridFooterTemplate let-column=\"column\">\r\n\t\t\t\t{{ getComputeTotalAmount }}\r\n\t\t\t</ng-template> -->\r\n\t\t</kendo-grid-column>\r\n\r\n\t\t<kendo-grid-column [style]=\"{'border-bottom':'1px solid black'}\" field=\"formatTotalNumber\" title=\"Thành tiền(vnđ)\"\r\n\t\t\twidth=\"30%\" >\r\n\t\t\t<ng-template kendoGridFooterTemplate let-column=\"column\">\r\n\t\t\t\t<!-- {{ totals[column.field].sum}} -->\r\n\t\t\t\t{{computeTotal}}\r\n\t\t\t</ng-template>\r\n\t\t</kendo-grid-column>\r\n\t</kendo-grid>\r\n</div>\r\n<div class=\"address\">\r\n\t<div *ngIf=\"!autoCheckDate\" class=\"from\">\r\n\t\t<br>\r\n\t\tSố tiền(bằng chữ)....................................................................................\r\n\r\n\t\t<br>\r\n\t\tNgày ....., Tháng ....., Năm 2020\r\n\t\t<br>\r\n\t\t<div style=\"text-align: center;\" class=\"row\">\r\n\t\t\t<div  class=\"col\">\r\n\t\t\t\tChữ kí khách\r\n\t\t\t</div>\r\n\t\t\t<div class=\"col\">Chủ cửa hàng</div>\r\n\t\t</div>\r\n\t</div>\r\n\t<div *ngIf=\"autoCheckDate\" class=\"from\">\r\n\t\t<br>\r\n\t\tSố tiền(bằng chữ)....................................................................................\r\n\r\n\t\t<br>\r\n\t\t{{fillDate}}\r\n\t\t<br>\r\n\t\t<div style=\"text-align: center;\" class=\"row\">\r\n\t\t\t<div  class=\"col\">\r\n\t\t\t\tChữ kí khách\r\n\t\t\t</div>\r\n\t\t\t<div class=\"col\">Chủ cửa hàng</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>"

/***/ }),

/***/ "./src/app/common/genfilename.ts":
/*!***************************************!*\
  !*** ./src/app/common/genfilename.ts ***!
  \***************************************/
/*! exports provided: GenerateFileName */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GenerateFileName", function() { return GenerateFileName; });
var GenerateFileName = /** @class */ (function () {
    function GenerateFileName() {
    }
    GenerateFileName.genfileName = function (customerName) {
        if (!customerName || customerName === '') {
            customerName = 'KhachLe';
        }
        var date = new Date();
        var homnay = date.getDate() + '' + (date.getMonth() + 1) + '' + date.getFullYear();
        return customerName + '-' + homnay;
    };
    GenerateFileName.genNormalReportName = function (fromDate, toDate, something) {
        return 'Báo cáo ' + something + fromDate + '-' + toDate;
    };
    GenerateFileName.printListMedicine = function () {
        return 'Danh sách thuốc';
    };
    return GenerateFileName;
}());



/***/ }),

/***/ "./src/app/pages/sell-medicine/invoice/invoice.component.scss":
/*!********************************************************************!*\
  !*** ./src/app/pages/sell-medicine/invoice/invoice.component.scss ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".header {\n  font-size: 20px;\n  font-weight: bold;\n  margin: 0 0 10px 0;\n  border-bottom: 1px solid #e5e5e5;\n  color: #3aabf0;\n}\n\n.address {\n  display: flex;\n  justify-content: left;\n  text-align: right;\n  margin: 0 0 20px 0;\n}\n\n.from p, .for {\n  color: black;\n  text-align: left;\n  font-size: 11px;\n}\n\n.from {\n  width: 100%;\n  text-align: right;\n}\n\ndiv {\n  font-family: \"DejaVu Sans\", \"Arial\", sans-serif;\n  font-size: 10px;\n}\n\n.page-template {\n  font-family: \"DejaVu Sans\", \"Arial\", sans-serif;\n  position: absolute;\n  width: 100%;\n  height: 100%;\n  top: 0;\n  left: 0;\n}\n\n.page-template .header {\n  position: absolute;\n  top: 30px;\n  left: 30px;\n  right: 30px;\n  border-bottom: 1px solid #888;\n  color: #888;\n}\n\n.page-template .footer {\n  position: absolute;\n  bottom: 30px;\n  left: 30px;\n  right: 30px;\n  border-top: 1px solid #888;\n  text-align: center;\n  color: #888;\n}\n\n/*\n  The example loads the DejaVu Sans from the Kendo UI CDN.\n  Other fonts have to be hosted from your application.\n  The official site of the Deja Vu Fonts project is\n  https://dejavu-fonts.github.io/.\n*/\n\n@font-face {\n  font-family: \"DejaVu Sans\";\n  src: url(\"https://kendo.cdn.telerik.com/2020.1.114/styles/fonts/DejaVu/DejaVuSans.ttf\") format(\"truetype\");\n}\n\n@font-face {\n  font-family: \"DejaVu Sans\";\n  font-weight: bold;\n  src: url(\"https://kendo.cdn.telerik.com/2020.1.114/styles/fonts/DejaVu/DejaVuSans-Bold.ttf\") format(\"truetype\");\n}\n\n@font-face {\n  font-family: \"DejaVu Sans\";\n  font-style: italic;\n  src: url(\"https://kendo.cdn.telerik.com/2020.1.114/styles/fonts/DejaVu/DejaVuSans-Oblique.ttf\") format(\"truetype\");\n}\n\n@font-face {\n  font-family: \"DejaVu Sans\";\n  font-weight: bold;\n  font-style: italic;\n  src: url(\"https://kendo.cdn.telerik.com/2020.1.114/styles/fonts/DejaVu/DejaVuSans-Oblique.ttf\") format(\"truetype\");\n}\n\n.k-grid {\n  font-family: \"DejaVu Sans\", \"Arial\", sans-serif;\n  font-size: 10px;\n  border-bottom: 1px solid black;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcGFnZXMvc2VsbC1tZWRpY2luZS9pbnZvaWNlL0Q6XFxDYXJyaWVyXFxhbmd1bGFyXFxuZ3gtYWRtaW4tbWFzdGVyL3NyY1xcYXBwXFxwYWdlc1xcc2VsbC1tZWRpY2luZVxcaW52b2ljZVxcaW52b2ljZS5jb21wb25lbnQuc2NzcyIsInNyYy9hcHAvcGFnZXMvc2VsbC1tZWRpY2luZS9pbnZvaWNlL2ludm9pY2UuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDSSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxrQkFBQTtFQUNBLGdDQUFBO0VBQ0EsY0FBQTtBQ0NKOztBREVFO0VBQ0ksYUFBQTtFQUNBLHFCQUFBO0VBQ0EsaUJBQUE7RUFDQSxrQkFBQTtBQ0NOOztBREVFO0VBQ0UsWUFBQTtFQUNBLGdCQUFBO0VBQ0EsZUFBQTtBQ0NKOztBRENFO0VBQ0UsV0FBQTtFQUNBLGlCQUFBO0FDRUo7O0FEQUE7RUFDRSwrQ0FBQTtFQUNBLGVBQUE7QUNHRjs7QUREQTtFQUNFLCtDQUFBO0VBQ0Esa0JBQUE7RUFDQSxXQUFBO0VBQ0EsWUFBQTtFQUNBLE1BQUE7RUFDQSxPQUFBO0FDSUY7O0FEREE7RUFDRSxrQkFBQTtFQUNBLFNBQUE7RUFDQSxVQUFBO0VBQ0EsV0FBQTtFQUNBLDZCQUFBO0VBQ0EsV0FBQTtBQ0lGOztBRERBO0VBQ0Usa0JBQUE7RUFDQSxZQUFBO0VBQ0EsVUFBQTtFQUNBLFdBQUE7RUFDQSwwQkFBQTtFQUNBLGtCQUFBO0VBQ0EsV0FBQTtBQ0lGOztBREZBOzs7OztDQUFBOztBQU1BO0VBQ0UsMEJBQUE7RUFDQSwwR0FBQTtBQ0tGOztBREZBO0VBQ0UsMEJBQUE7RUFDQSxpQkFBQTtFQUNBLCtHQUFBO0FDSUY7O0FEREE7RUFDRSwwQkFBQTtFQUNBLGtCQUFBO0VBQ0Esa0hBQUE7QUNHRjs7QURBQTtFQUNFLDBCQUFBO0VBQ0EsaUJBQUE7RUFDQSxrQkFBQTtFQUNBLGtIQUFBO0FDRUY7O0FEQUE7RUFDRSwrQ0FBQTtFQUNBLGVBQUE7RUFDQSw4QkFBQTtBQ0VGIiwiZmlsZSI6InNyYy9hcHAvcGFnZXMvc2VsbC1tZWRpY2luZS9pbnZvaWNlL2ludm9pY2UuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuaGVhZGVyIHtcclxuICAgIGZvbnQtc2l6ZTogMjBweDtcclxuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG4gICAgbWFyZ2luOiAwIDAgMTBweCAwO1xyXG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICNlNWU1ZTU7XHJcbiAgICBjb2xvcjogIzNhYWJmMDtcclxuICB9XHJcblxyXG4gIC5hZGRyZXNzIHtcclxuICAgICAgZGlzcGxheTogZmxleDtcclxuICAgICAganVzdGlmeS1jb250ZW50OiBsZWZ0O1xyXG4gICAgICB0ZXh0LWFsaWduOiByaWdodDtcclxuICAgICAgbWFyZ2luOiAwIDAgMjBweCAwO1xyXG4gIH1cclxuXHJcbiAgLmZyb20gcCwgLmZvciB7XHJcbiAgICBjb2xvcjogYmxhY2s7XHJcbiAgICB0ZXh0LWFsaWduOiBsZWZ0O1xyXG4gICAgZm9udC1zaXplOiAxMXB4O1xyXG4gIH1cclxuICAuZnJvbXtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgdGV4dC1hbGlnbjogcmlnaHQ7XHJcbiAgfVxyXG5kaXYge1xyXG4gIGZvbnQtZmFtaWx5OiBcIkRlamFWdSBTYW5zXCIsIFwiQXJpYWxcIiwgc2Fucy1zZXJpZjtcclxuICBmb250LXNpemU6IDEwcHg7XHJcbn1cclxuLnBhZ2UtdGVtcGxhdGUge1xyXG4gIGZvbnQtZmFtaWx5OiBcIkRlamFWdSBTYW5zXCIsIFwiQXJpYWxcIiwgc2Fucy1zZXJpZjtcclxuICBwb3NpdGlvbjogYWJzb2x1dGU7XHJcbiAgd2lkdGg6IDEwMCU7XHJcbiAgaGVpZ2h0OiAxMDAlO1xyXG4gIHRvcDogMDtcclxuICBsZWZ0OiAwO1xyXG59XHJcblxyXG4ucGFnZS10ZW1wbGF0ZSAuaGVhZGVyIHtcclxuICBwb3NpdGlvbjogYWJzb2x1dGU7XHJcbiAgdG9wOiAzMHB4O1xyXG4gIGxlZnQ6IDMwcHg7XHJcbiAgcmlnaHQ6IDMwcHg7XHJcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICM4ODg7XHJcbiAgY29sb3I6ICM4ODg7XHJcbn1cclxuXHJcbi5wYWdlLXRlbXBsYXRlIC5mb290ZXIge1xyXG4gIHBvc2l0aW9uOiBhYnNvbHV0ZTtcclxuICBib3R0b206IDMwcHg7XHJcbiAgbGVmdDogMzBweDtcclxuICByaWdodDogMzBweDtcclxuICBib3JkZXItdG9wOiAxcHggc29saWQgIzg4ODtcclxuICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgY29sb3I6ICM4ODg7XHJcbn1cclxuLypcclxuICBUaGUgZXhhbXBsZSBsb2FkcyB0aGUgRGVqYVZ1IFNhbnMgZnJvbSB0aGUgS2VuZG8gVUkgQ0ROLlxyXG4gIE90aGVyIGZvbnRzIGhhdmUgdG8gYmUgaG9zdGVkIGZyb20geW91ciBhcHBsaWNhdGlvbi5cclxuICBUaGUgb2ZmaWNpYWwgc2l0ZSBvZiB0aGUgRGVqYSBWdSBGb250cyBwcm9qZWN0IGlzXHJcbiAgaHR0cHM6Ly9kZWphdnUtZm9udHMuZ2l0aHViLmlvLy5cclxuKi9cclxuQGZvbnQtZmFjZSB7XHJcbiAgZm9udC1mYW1pbHk6IFwiRGVqYVZ1IFNhbnNcIjtcclxuICBzcmM6IHVybChcImh0dHBzOi8va2VuZG8uY2RuLnRlbGVyaWsuY29tLzIwMjAuMS4xMTQvc3R5bGVzL2ZvbnRzL0RlamFWdS9EZWphVnVTYW5zLnR0ZlwiKSBmb3JtYXQoXCJ0cnVldHlwZVwiKTtcclxufVxyXG5cclxuQGZvbnQtZmFjZSB7XHJcbiAgZm9udC1mYW1pbHk6IFwiRGVqYVZ1IFNhbnNcIjtcclxuICBmb250LXdlaWdodDogYm9sZDtcclxuICBzcmM6IHVybChcImh0dHBzOi8va2VuZG8uY2RuLnRlbGVyaWsuY29tLzIwMjAuMS4xMTQvc3R5bGVzL2ZvbnRzL0RlamFWdS9EZWphVnVTYW5zLUJvbGQudHRmXCIpIGZvcm1hdChcInRydWV0eXBlXCIpO1xyXG59XHJcblxyXG5AZm9udC1mYWNlIHtcclxuICBmb250LWZhbWlseTogXCJEZWphVnUgU2Fuc1wiO1xyXG4gIGZvbnQtc3R5bGU6IGl0YWxpYztcclxuICBzcmM6IHVybChcImh0dHBzOi8va2VuZG8uY2RuLnRlbGVyaWsuY29tLzIwMjAuMS4xMTQvc3R5bGVzL2ZvbnRzL0RlamFWdS9EZWphVnVTYW5zLU9ibGlxdWUudHRmXCIpIGZvcm1hdChcInRydWV0eXBlXCIpO1xyXG59XHJcblxyXG5AZm9udC1mYWNlIHtcclxuICBmb250LWZhbWlseTogXCJEZWphVnUgU2Fuc1wiO1xyXG4gIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG4gIGZvbnQtc3R5bGU6IGl0YWxpYztcclxuICBzcmM6IHVybChcImh0dHBzOi8va2VuZG8uY2RuLnRlbGVyaWsuY29tLzIwMjAuMS4xMTQvc3R5bGVzL2ZvbnRzL0RlamFWdS9EZWphVnVTYW5zLU9ibGlxdWUudHRmXCIpIGZvcm1hdChcInRydWV0eXBlXCIpO1xyXG59XHJcbi5rLWdyaWQge1xyXG4gIGZvbnQtZmFtaWx5OiBcIkRlamFWdSBTYW5zXCIsIFwiQXJpYWxcIiwgc2Fucy1zZXJpZjtcclxuICBmb250LXNpemU6IDEwcHg7XHJcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIGJsYWNrO1xyXG59IiwiLmhlYWRlciB7XG4gIGZvbnQtc2l6ZTogMjBweDtcbiAgZm9udC13ZWlnaHQ6IGJvbGQ7XG4gIG1hcmdpbjogMCAwIDEwcHggMDtcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICNlNWU1ZTU7XG4gIGNvbG9yOiAjM2FhYmYwO1xufVxuXG4uYWRkcmVzcyB7XG4gIGRpc3BsYXk6IGZsZXg7XG4gIGp1c3RpZnktY29udGVudDogbGVmdDtcbiAgdGV4dC1hbGlnbjogcmlnaHQ7XG4gIG1hcmdpbjogMCAwIDIwcHggMDtcbn1cblxuLmZyb20gcCwgLmZvciB7XG4gIGNvbG9yOiBibGFjaztcbiAgdGV4dC1hbGlnbjogbGVmdDtcbiAgZm9udC1zaXplOiAxMXB4O1xufVxuXG4uZnJvbSB7XG4gIHdpZHRoOiAxMDAlO1xuICB0ZXh0LWFsaWduOiByaWdodDtcbn1cblxuZGl2IHtcbiAgZm9udC1mYW1pbHk6IFwiRGVqYVZ1IFNhbnNcIiwgXCJBcmlhbFwiLCBzYW5zLXNlcmlmO1xuICBmb250LXNpemU6IDEwcHg7XG59XG5cbi5wYWdlLXRlbXBsYXRlIHtcbiAgZm9udC1mYW1pbHk6IFwiRGVqYVZ1IFNhbnNcIiwgXCJBcmlhbFwiLCBzYW5zLXNlcmlmO1xuICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gIHdpZHRoOiAxMDAlO1xuICBoZWlnaHQ6IDEwMCU7XG4gIHRvcDogMDtcbiAgbGVmdDogMDtcbn1cblxuLnBhZ2UtdGVtcGxhdGUgLmhlYWRlciB7XG4gIHBvc2l0aW9uOiBhYnNvbHV0ZTtcbiAgdG9wOiAzMHB4O1xuICBsZWZ0OiAzMHB4O1xuICByaWdodDogMzBweDtcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICM4ODg7XG4gIGNvbG9yOiAjODg4O1xufVxuXG4ucGFnZS10ZW1wbGF0ZSAuZm9vdGVyIHtcbiAgcG9zaXRpb246IGFic29sdXRlO1xuICBib3R0b206IDMwcHg7XG4gIGxlZnQ6IDMwcHg7XG4gIHJpZ2h0OiAzMHB4O1xuICBib3JkZXItdG9wOiAxcHggc29saWQgIzg4ODtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuICBjb2xvcjogIzg4ODtcbn1cblxuLypcbiAgVGhlIGV4YW1wbGUgbG9hZHMgdGhlIERlamFWdSBTYW5zIGZyb20gdGhlIEtlbmRvIFVJIENETi5cbiAgT3RoZXIgZm9udHMgaGF2ZSB0byBiZSBob3N0ZWQgZnJvbSB5b3VyIGFwcGxpY2F0aW9uLlxuICBUaGUgb2ZmaWNpYWwgc2l0ZSBvZiB0aGUgRGVqYSBWdSBGb250cyBwcm9qZWN0IGlzXG4gIGh0dHBzOi8vZGVqYXZ1LWZvbnRzLmdpdGh1Yi5pby8uXG4qL1xuQGZvbnQtZmFjZSB7XG4gIGZvbnQtZmFtaWx5OiBcIkRlamFWdSBTYW5zXCI7XG4gIHNyYzogdXJsKFwiaHR0cHM6Ly9rZW5kby5jZG4udGVsZXJpay5jb20vMjAyMC4xLjExNC9zdHlsZXMvZm9udHMvRGVqYVZ1L0RlamFWdVNhbnMudHRmXCIpIGZvcm1hdChcInRydWV0eXBlXCIpO1xufVxuQGZvbnQtZmFjZSB7XG4gIGZvbnQtZmFtaWx5OiBcIkRlamFWdSBTYW5zXCI7XG4gIGZvbnQtd2VpZ2h0OiBib2xkO1xuICBzcmM6IHVybChcImh0dHBzOi8va2VuZG8uY2RuLnRlbGVyaWsuY29tLzIwMjAuMS4xMTQvc3R5bGVzL2ZvbnRzL0RlamFWdS9EZWphVnVTYW5zLUJvbGQudHRmXCIpIGZvcm1hdChcInRydWV0eXBlXCIpO1xufVxuQGZvbnQtZmFjZSB7XG4gIGZvbnQtZmFtaWx5OiBcIkRlamFWdSBTYW5zXCI7XG4gIGZvbnQtc3R5bGU6IGl0YWxpYztcbiAgc3JjOiB1cmwoXCJodHRwczovL2tlbmRvLmNkbi50ZWxlcmlrLmNvbS8yMDIwLjEuMTE0L3N0eWxlcy9mb250cy9EZWphVnUvRGVqYVZ1U2Fucy1PYmxpcXVlLnR0ZlwiKSBmb3JtYXQoXCJ0cnVldHlwZVwiKTtcbn1cbkBmb250LWZhY2Uge1xuICBmb250LWZhbWlseTogXCJEZWphVnUgU2Fuc1wiO1xuICBmb250LXdlaWdodDogYm9sZDtcbiAgZm9udC1zdHlsZTogaXRhbGljO1xuICBzcmM6IHVybChcImh0dHBzOi8va2VuZG8uY2RuLnRlbGVyaWsuY29tLzIwMjAuMS4xMTQvc3R5bGVzL2ZvbnRzL0RlamFWdS9EZWphVnVTYW5zLU9ibGlxdWUudHRmXCIpIGZvcm1hdChcInRydWV0eXBlXCIpO1xufVxuLmstZ3JpZCB7XG4gIGZvbnQtZmFtaWx5OiBcIkRlamFWdSBTYW5zXCIsIFwiQXJpYWxcIiwgc2Fucy1zZXJpZjtcbiAgZm9udC1zaXplOiAxMHB4O1xuICBib3JkZXItYm90dG9tOiAxcHggc29saWQgYmxhY2s7XG59Il19 */"

/***/ }),

/***/ "./src/app/pages/sell-medicine/invoice/invoice.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/pages/sell-medicine/invoice/invoice.component.ts ***!
  \******************************************************************/
/*! exports provided: InvoiceComponent, InvoiceRow */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceComponent", function() { return InvoiceComponent; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceRow", function() { return InvoiceRow; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _progress_kendo_data_query__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @progress/kendo-data-query */ "./node_modules/@progress/kendo-data-query/dist/es/main.js");
/* harmony import */ var _log_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../log.service */ "./src/app/log.service.ts");




var InvoiceComponent = /** @class */ (function () {
    function InvoiceComponent(logger) {
        this.logger = logger;
        this.autoCheckDate = true;
        this.customer = { name: 'Không tên' };
        this.isEmoss = true;
        this.dungThuoc = 'dung thuoc';
        this.data = [];
        this.aggregates = [{
                field: 'qty', aggregate: 'sum'
            }, {
                field: 'total', aggregate: 'sum'
            }];
    }
    Object.defineProperty(InvoiceComponent.prototype, "fillDate", {
        get: function () {
            var homnay = 'Ngày';
            var date = new Date();
            var ngay = 'Ngày ' + date.getDate();
            var thang = ' ,Tháng ' + (date.getMonth() + 1);
            var nam = ' ,Năm ' + date.getFullYear();
            homnay = ngay + thang + nam;
            return homnay;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InvoiceComponent.prototype, "totals", {
        get: function () {
            return Object(_progress_kendo_data_query__WEBPACK_IMPORTED_MODULE_2__["aggregateBy"])(this.data, this.aggregates) || {};
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InvoiceComponent.prototype, "computeTotal", {
        get: function () {
            var a = 0;
            this.data.forEach(function (e) {
                a = a + e.qty * (e.unitPrice + e.addMore);
            });
            return a.toLocaleString('vi-vn');
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InvoiceComponent.prototype, "getUnitPrice", {
        get: function () {
            return;
        },
        enumerable: true,
        configurable: true
    });
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Boolean)
    ], InvoiceComponent.prototype, "autoCheckDate", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], InvoiceComponent.prototype, "customer", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Boolean)
    ], InvoiceComponent.prototype, "isEmoss", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], InvoiceComponent.prototype, "dungThuoc", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], InvoiceComponent.prototype, "data", void 0);
    InvoiceComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'my-invoice',
            template: __webpack_require__(/*! raw-loader!./invoice.component.html */ "./node_modules/raw-loader/index.js!./src/app/pages/sell-medicine/invoice/invoice.component.html"),
            providers: [_log_service__WEBPACK_IMPORTED_MODULE_3__["Logger"]],
            styles: [__webpack_require__(/*! ./invoice.component.scss */ "./src/app/pages/sell-medicine/invoice/invoice.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_log_service__WEBPACK_IMPORTED_MODULE_3__["Logger"]])
    ], InvoiceComponent);
    return InvoiceComponent;
}());

var InvoiceRow = /** @class */ (function () {
    function InvoiceRow(productName, unitPrice, addMore, qty, unit) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.addMore = addMore;
        this.qty = qty;
        this.unit = unit;
    }
    Object.defineProperty(InvoiceRow.prototype, "formatNumber", {
        get: function () {
            var a = (this.unitPrice + this.addMore).toLocaleString('vi-vn');
            return a;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InvoiceRow.prototype, "formatTotalNumber", {
        get: function () {
            var a = (this.unitPrice + this.addMore) * this.qty;
            return a.toLocaleString('vi-vn');
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InvoiceRow.prototype, "total", {
        get: function () {
            return (this.unitPrice + this.addMore) * this.qty;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InvoiceRow.prototype, "amountColumn", {
        get: function () {
            var result = '';
            result = this.qty + ' ' + this.unit;
            return result;
        },
        enumerable: true,
        configurable: true
    });
    return InvoiceRow;
}());



/***/ })

}]);
//# sourceMappingURL=default~report-report-module~sell-medicine-sell-medicine-module-es5.js.map