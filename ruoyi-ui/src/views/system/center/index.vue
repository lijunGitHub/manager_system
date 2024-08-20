<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="中 心 名 称:" prop="monitorCenterName"  label-width="88px">
        <el-input
          v-model="queryParams.monitorCenterName"
          placeholder="请输入监控中心名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地  址  区  域:" prop="address"  label-width="100px">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入地址区域"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上级监控中心:"  prop="location">
        <el-cascader
            placeholder="请选择所在地"
            v-model="queryParams.monitorCenterParentId"
            :options="locationOptions"
            :props="locationProps"
            @change="handleLocationChange"
            clearable
        />
      </el-form-item>
      <el-form-item label="中 心 级 别:" prop="centerLevel" label-width="88px">
        <el-select v-model="queryParams.centerLevel" placeholder="请选择中心级别" clearable>
          <el-option
            v-for="dict in dict.type.sys_center_level"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否为分公司:" prop="isBranchOffice" label-width="100px">
        <el-select v-model="queryParams.isBranchOffice" placeholder="请选择是否为分公司" clearable>
          <el-option
            v-for="dict in dict.type.sys_common_switch"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所属分公司:" prop="affiliatedBranches" label-width="88px">
        <template>
          <el-select
              size="small"
              v-model="queryParams.affiliatedBranches"
              filterable
              placeholder="请选择"
              style="width: 183px"
              @change="handleSelectCompanyChange"
          >
            <el-option
                v-for="item in companyOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </template>

      </el-form-item>
      <el-form-item label="监控中心电话:" prop="monitorCenterPhone" label-width="100px">
        <el-input
          v-model="queryParams.monitorCenterPhone"
          placeholder="请输入监控中心电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负 责 人 姓名:" prop="responsiblePersonName">
        <el-input
          v-model="queryParams.responsiblePersonName"
          placeholder="请输入负责人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责人电话:" prop="responsiblePersonPhone" label-width="88px">
        <el-input
          v-model="queryParams.responsiblePersonPhone"
          placeholder="请输入负责人电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="经纬度" prop="latAndLon">-->
<!--        <el-input-->
<!--          v-model="queryParams.latAndLon"-->
<!--          placeholder="请输入经纬度"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:center:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:center:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:center:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:center:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="centerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="监控中心名称" align="center" prop="monitorCenterName" />
      <el-table-column label="地址区域" align="center" prop="address" />
      <el-table-column label="上级监控中心" align="center"  prop="monitorCenterParentName">
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_common_switch" :value="scope.row.monitorCenterParentId"/>-->
<!--        </template>-->
<!--        <el-form-item label="上级监控中心"  prop="location">-->
<!--          <el-cascader-->
<!--              placeholder="请选择上级监控中心"-->
<!--              v-model="form.monitorCenterParentId"-->
<!--              :options="locationOptions"-->
<!--              :props="locationProps"-->
<!--              @change="handleLocationChange"-->
<!--              clearable-->
<!--          />-->
<!--        </el-form-item>-->
      </el-table-column>
      <el-table-column label="中心级别" align="center" prop="centerLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_center_level" :value="scope.row.centerLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="是否为分公司" align="center" prop="isBranchOffice">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_switch" :value="scope.row.isBranchOffice"/>
        </template>
      </el-table-column>
      <el-table-column label="所属分公司" align="center" prop="companyName">
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_common_switch" :value="scope.row.affiliatedBranches"/>-->
<!--        </template>-->
      </el-table-column>
      <el-table-column label="监控中心电话" align="center" prop="monitorCenterPhone" />
      <el-table-column label="负责人姓名" align="center" prop="responsiblePersonName" />
      <el-table-column label="负责人电话" align="center" prop="responsiblePersonPhone" />
      <el-table-column label="守护人员" align="center" prop="guardians" />
      <el-table-column label="守护区域" align="center" prop="guardianArea" />
      <el-table-column label="镇街数量" align="center" prop="townNumber" />
      <el-table-column label="社区数量" align="center" prop="communityNumber" />
      <el-table-column label="监控中心详址" align="center" prop="monitorCenterDetailAddress" />
      <el-table-column label="经纬度" align="center" prop="latAndLon" />
      <el-table-column label="大屏地图层级" align="center" prop="largeScreenMapLevel" />
      <el-table-column label="告警处置" align="center" prop="handleAlarms">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_switch" :value="scope.row.handleAlarms"/>
        </template>
      </el-table-column>
      <el-table-column label="设备统计" align="center" prop="deviceStatistics">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_switch" :value="scope.row.deviceStatistics"/>
        </template>
      </el-table-column>
      <el-table-column label="全景图" align="center" prop="panorama" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.panorama" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="火灾处置单是否站内消息通知" align="center" prop="fireDisposalOrderIsnotify">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_switch" :value="scope.row.fireDisposalOrderIsnotify"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:center:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:center:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改监控中心管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="监控中心名称" prop="monitorCenterName">
          <el-input v-model="form.monitorCenterName" placeholder="请输入监控中心名称" />
        </el-form-item>
        <el-form-item label="地址区域" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址区域" />
        </el-form-item>
        <el-form-item label="上级监控中心" prop="location">
          <!-- 监控中心级联选择器 -->
                <el-cascader
                    placeholder="请选择所在地"
                    v-model="form.monitorCenterParentId"
                    :options="locationOptions"
                    :props="locationProps"
                    @change="handleLocationChange"
                    clearable
                />
<!--          <el-select v-model="form.monitorCenterParentId" placeholder="请选择上级监控中心">-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.sys_common_switch"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="parseInt(dict.value)"-->
<!--            ></el-option>-->
<!--          </el-select>-->
        </el-form-item>
        <el-form-item label="中心级别" prop="centerLevel">
          <el-select v-model="form.centerLevel" placeholder="请选择中心级别">
            <el-option
              v-for="dict in dict.type.sys_center_level"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否为分公司" prop="isBranchOffice">
          <el-select v-model="form.isBranchOffice" placeholder="请选择是否为分公司">
            <el-option
              v-for="dict in dict.type.sys_common_switch"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属分公司" prop="affiliatedBranches">
          <template>
            <el-select
                v-model="form.affiliatedBranches"
                filterable
                placeholder="请选择"
                style="width: 200px"
                @change="handleSelectCompanyChange"
            >
              <el-option
                  v-for="item in companyOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
              />
            </el-select>
          </template>
<!--          <el-select v-model="form.affiliatedBranches" placeholder="请选择所属分公司ID">-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.sys_common_switch"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="parseInt(dict.value)"-->
<!--            ></el-option>-->
<!--          </el-select>-->
        </el-form-item>
        <el-form-item label="监控中心电话" prop="monitorCenterPhone">
          <el-input v-model="form.monitorCenterPhone" placeholder="请输入监控中心电话" />
        </el-form-item>
        <el-form-item label="负责人姓名" prop="responsiblePersonName">
          <el-input v-model="form.responsiblePersonName" placeholder="请输入负责人姓名" />
        </el-form-item>
        <el-form-item label="负责人电话" prop="responsiblePersonPhone">
          <el-input v-model="form.responsiblePersonPhone" placeholder="请输入负责人电话" />
        </el-form-item>
        <el-form-item label="守护人员" prop="guardians">
          <el-input v-model="form.guardians" placeholder="请输入守护人员" />
        </el-form-item>
        <el-form-item label="守护区域" prop="guardianArea">
          <el-input v-model="form.guardianArea" placeholder="请输入守护区域" />
        </el-form-item>
        <el-form-item label="镇街数量" prop="townNumber">
          <el-input v-model="form.townNumber" placeholder="请输入镇街数量" />
        </el-form-item>
        <el-form-item label="社区数量" prop="communityNumber">
          <el-input v-model="form.communityNumber" placeholder="请输入社区数量" />
        </el-form-item>
        <el-form-item label="监控中心详址" prop="monitorCenterDetailAddress">
          <el-input v-model="form.monitorCenterDetailAddress" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="经纬度" prop="latAndLon">
          <el-input v-model="form.latAndLon" placeholder="请输入经纬度" />
        </el-form-item>
        <el-form-item label="大屏地图层级" prop="largeScreenMapLevel">
          <el-input v-model="form.largeScreenMapLevel" placeholder="请输入大屏地图层级" />
        </el-form-item>
        <el-form-item label="告警处置" prop="handleAlarms">
          <el-select v-model="form.handleAlarms" placeholder="请选择告警处置">
            <el-option
              v-for="dict in dict.type.sys_common_switch"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="设备统计" prop="deviceStatistics">
          <el-select v-model="form.deviceStatistics" placeholder="请选择设备统计">
            <el-option
              v-for="dict in dict.type.sys_common_switch"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="全景图" prop="panorama">
          <image-upload v-model="form.panorama"/>
        </el-form-item>
        <el-form-item label="火灾处置单是否站内消息通知" prop="fireDisposalOrderIsnotify">
          <el-select v-model="form.fireDisposalOrderIsnotify" placeholder="请选择火灾处置单是否站内消息通知">
            <el-option
              v-for="dict in dict.type.sys_common_switch"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listCenter,
  getCenter,
  delCenter,
  addCenter,
  updateCenter,
  getTopParent,
  getSubById,
  getParentById
} from "@/api/system/center";
import {
  getCompanyName
} from "@/api/system/company";

export default {
  name: "Center",
  dicts: ['sys_common_switch', 'sys_center_level'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 监控中心管理表格数据
      centerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      locationOptions:[0],
      locationProps:{
        value:"value",
        label: "label",
        children: "children",
        lazy:true,
        lazyLoad:this.loadLocationData,
        checkStrictly:true
      },
      monitorId:0,
      selectedLabels:[],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        monitorCenterName: null,
        address: null,
        monitorCenterParentId: null,
        monitorCenterParentName: null,
        centerLevel: null,
        isBranchOffice: null,
        affiliatedBranches: null,
        monitorCenterPhone: null,
        responsiblePersonName: null,
        responsiblePersonPhone: null,
        monitorCenterDetailAddress: null,
        latAndLon: null,
      },
      affiliatedBranches:null,
      companyOptions:[],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        monitorCenterName: [
          { required: true, message: "监控中心名称不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "地址区域不能为空", trigger: "blur" }
        ],
        monitorCenterParentId: [
          { required: true, message: "上级监控中心不能为空", trigger: "change" }
        ],
        isBranchOffice: [
          { required: true, message: "是否为分公司不能为空", trigger: "change" }
        ],
        affiliatedBranches: [
          { required: true, message: "所属分公司ID不能为空", trigger: "change" }
        ],
        monitorCenterDetailAddress: [
          { required: true, message: "监控中心详址不能为空", trigger: "blur" }
        ],
        handleAlarms: [
          { required: true, message: "告警处置不能为空", trigger: "change" }
        ],
        deviceStatistics: [
          { required: true, message: "设备统计不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getTopParentList();
    this.initCompanyNameList();
  },
  methods: {
    /** 查询监控中心管理列表 */
    getList() {
      this.loading = true;
      listCenter(this.queryParams).then(response => {
        this.centerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getTopParentList() {
      this.loading = true;
      this.queryParams.pageSize=10000
      getTopParent(this.queryParams).then(response => {
        this.locationOptions=response.data.data;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        monitorCenterName: null,
        address: null,
        monitorCenterParentId: null,
        monitorCenterParentName: null,
        centerLevel: null,
        isBranchOffice: null,
        affiliatedBranches: null,
        companyName:null,
        monitorCenterPhone: null,
        responsiblePersonName: null,
        responsiblePersonPhone: null,
        guardians: null,
        guardianArea: null,
        townNumber: null,
        communityNumber: null,
        monitorCenterDetailAddress: null,
        latAndLon: null,
        largeScreenMapLevel: null,
        handleAlarms: null,
        deviceStatistics: null,
        panorama: null,
        fireDisposalOrderIsnotify: null,
        updateTime: null,
        createTime: null
      };
      this.queryParams.monitorCenterParentId=null;
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.queryParams.monitorCenterParentId=null;
      this.form.monitorCenterParentId=null;
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.initCompanyNameList()
      this.open = true;
      this.title = "添加监控中心管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      this.monitorId = id;
      getCenter(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改监控中心管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCenter(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCenter(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除监控中心管理编号为"' + ids + '"的数据项？').then(function() {
        return delCenter(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/center/export', {
        ...this.queryParams
      }, `center_${new Date().getTime()}.xlsx`)
    },
    handleLocationChange(values,labels) {
      if(values !== undefined) {
        this.form.monitorCenterParentId = values[values.length - 1]
        this.queryParams.monitorCenterParentId = values[values.length - 1]
        console.log(this.form.monitorCenterParentId)
      }
    },
    //加载懒数据
    loadLocationData(node,resolve){
      const  {value} = node;
      const  {label} = node;
      this.form.monitorCenterParentName = label
      console.log("sss6",this.form.monitorCenterParentName )
      this.queryParams.pageSize=1000000;
      if(value === undefined){
        getParentById(this.monitorId).then(response => {
          console.log("sss",response)
          this.locationOptions=response.data.data
        });
      }else {
        getSubById(value).then(response => {
          console.log(response.data.data)
          resolve(response.data.data);
        });
      }

    },

    findOptionByValue(options, value) {
      for (let option of options) {
        if (option.value === value) {
          return option;
        }
        if (option.children && option.children.length > 0) {
          let result = this.findOptionByValue(option.children, value);
          if (result) {
            return result;
          }
        }
      }
      return null;
    },

    getSelectedLabels(values) {
      let labels = [];
      for (let value of values) {
        let option = this.findOptionByValue(this.locationOptions, value);
        if (option) {
          labels.push(option.label);
          // 如果当前选项还有子选项，递归获取子选项的 label
          if (option.children && option.children.length > 0) {
            let childLabels = this.getSelectedLabelsForChildren(option.children, values);
            labels = labels.concat(childLabels);
          }
        }
      }
      return labels;
    },

    getSelectedLabelsForChildren(children, values) {
      let labels = [];
      for (let child of children) {
        if (values.includes(child.value)) {
          labels.push(child.label);
          if (child.children && child.children.length > 0) {
            let childLabels = this.getSelectedLabelsForChildren(child.children, values);
            labels = labels.concat(childLabels);
          }
        }
      }
      return labels;
    },

    initCompanyNameList(){
      this.queryParams.pageSize=1000
      getCompanyName(this.queryParams).then(response => {
        this.companyOptions = response.data
      });
    },
    handleSelectCompanyChange(value){
      console.log('Selected Value:', value);
      this.form.affiliatedBranches = value;
    }



  }
};
</script>
