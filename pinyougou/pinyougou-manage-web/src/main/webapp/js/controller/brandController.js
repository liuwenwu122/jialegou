//控制层
    app.controller("brandController",function ($scope,brandService,$controller) {

    //    继承baseController
        $controller("baseController",{$scope:$scope});

    // 查询所有列表数据并绑定到 list对象
    $scope.findAll = function () {
        brandService.findAll().success(function (response) {
            $scope.list = response;
        });
    };



    $scope.findPage = function (pageNum, rows) {
        brandService.findPage(pageNum,rows).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;
                $scope.brandList = response.rows;
            })
    };

    //    添加品牌
    $scope.save = function () {
        var obj;
        //由于添加和更新是同一个方法,所有要判断id是否于空,如果不等于空表示是更新
        if ($scope.brand.id == null) {
            obj = brandService.add($scope.brand)
        }else {
            obj = brandService.update($scope.brand)
        }
        obj.success(
            function (response) {
                if (response.success) {
                    //    添加成功重新刷新列表
                    $scope.reloadList();
                } else {
                    //    添加失败提示用户
                    alert(response.messages)
                }
            });
    };

    // 根据id查询
    $scope.findOne = function (id) {
        brandService.findOne(id) .success(
            function (response) {
                $scope.brand = response
            });
    };


    //批量删除
    $scope.delete = function () {
        if ($scope.selectIds.length < 1) {
            alert("请选择要删除的品牌");
            return
        }
        if (confirm("确定要删除品牌吗!")) {
            brandService.delete($scope.selectIds).success(
                function (response) {
                    if (response.success) {
                        //删除后清空数组
                        $scope.selectIds = [];
                        $scope.reloadList();
                    } else {
                        alert(response.messages)
                    }
                });
        }
    };

    //根据条件搜索品牌
    // 新定义一个空对象,页面加载初始化的时候默认搜索条件为空
    $scope.searchBrand = {};

    $scope.search = function (pageNum, rows) {
        brandService.search(pageNum,rows,$scope.searchBrand).success(
            function (response) {
                $scope.brandList = response.rows;
                $scope.paginationConf.totalItems = response.total;
            })
    };
});
