
//定义继承器
app.controller("baseController", function ($scope) {

// 初始化分页参数
    $scope.paginationConf = {
        currentPage: 1,// 当前页号
        totalItems: 10,// 总记录数
        itemsPerPage: 5,// 页大小
        perPageOptions: [5, 10, 15, 20, 30],// 可选择的每页大小
        onChange: function () {	// 当上述的参数发生变化了后触发
            $scope.reloadList();
        }
    };

    $scope.reloadList = function () {
        // $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
    };

//定义一个数组保存选中的id
    $scope.selectIds = [];
//event代表一个复选框栏,target代表选中的目标,checked表示是否选中
    $scope.deleteSelectionIds = function ($event, id) {
        if ($event.target.checked) {
            // push表示想数组添加一个元素
            $scope.selectIds.push(id)
        } else {
            //indexOf表示获取元素在数组的索引
            var index = $scope.selectIds.indexOf(id);
            //splice表示根据索引删除数组指定位置的元素,1表示每次删一个元素
            $scope.selectIds.splice(index, 1)
        }
    };
});