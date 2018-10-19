//服务层
 app.service("brandService",function ($http) {
    // 查询所有列表数据
    this.findAll = function () {
        return $http.get("../brand/findAll.do");
    };

    //    分页查询
    this.findPage = function (pageNum, rows) {
        return $http.get("../brand/findPage.do?page=" + pageNum + "&rows=" + rows)
    };

    // 添加品牌
    this.add = function (brand) {
        return $http.post("../brand/add.do", brand)
    };

    // 更新品牌
    this.update = function (brand) {
        return $http.post("../brand/update.do", brand)
    };

    // 根据id查询
    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id=" + id)
    };

    //批量删除
    this.delete = function (selectIds) {
        return $http.get("../brand/delete.do?ids=" +selectIds)
    };

    //分页搜索
    this.search = function (pageNum, rows, searchBrand) {
        return $http.post("../brand/search.do?page=" + pageNum + "&rows=" + rows,searchBrand)
    };
});