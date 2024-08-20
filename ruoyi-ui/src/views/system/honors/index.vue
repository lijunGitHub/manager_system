<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="荣誉名称:" prop="honoraryName"  label-width="75px">
        <el-select v-model="queryParams.honoraryName" placeholder="请选择荣誉名称" clearable>
          <el-option
            v-for="dict in dict.type.honorary_name"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="荣誉类型:" prop="honoraryType" label-width="88px">
        <el-select v-model="queryParams.honoraryType" placeholder="请选择荣誉类型" clearable>
          <el-option
            v-for="dict in dict.type.honorary_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所属监控中心:" prop="belongMonitorCenter"   label-width="100px">
            <el-select
                size="small"
                v-model="queryParams.belongMonitorCenter"
                filterable
                placeholder="请选择所属监控中心"
                style="width: 183px"
                @change="handleSelectMonitorCenterChange"
            >
              <el-option
                  v-for="item in monitorCenters"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
              />
            </el-select>
      </el-form-item>
      <el-form-item label="颁发/报道单位:" prop="issuedUnits" label-width="110px">
        <el-select v-model="queryParams.issuedUnits" placeholder="请选择颁发单位/报道单位" clearable>
          <el-option
            v-for="dict in dict.type.issued_units"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="颁发/报道人:" prop="issuedPerson"   label-width="100px">
        <el-input
          v-model="queryParams.issuedPerson"
          placeholder="请输入颁发人/报道人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="颁发/报道时间:" prop="issuedTime" label-width="110px">
        <el-date-picker clearable
          v-model="queryParams.issuedTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择颁发时间/报道时间">
        </el-date-picker>
      </el-form-item>
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
          v-hasPermi="['system:honors:add']"
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
          v-hasPermi="['system:honors:edit']"
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
          v-hasPermi="['system:honors:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:honors:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="honorsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="荣誉名称" align="center" prop="honoraryName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.honorary_name" :value="scope.row.honoraryName"/>
        </template>
      </el-table-column>
      <el-table-column label="荣誉类型" align="center" prop="honoraryType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.honorary_type" :value="scope.row.honoraryType"/>
        </template>
      </el-table-column>
      <el-table-column label="所属监控中心" align="center" prop="monitorCenterName">
      </el-table-column>
      <el-table-column label="颁发单位/报道单位" align="center" prop="issuedUnits">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.issued_units" :value="scope.row.issuedUnits"/>
        </template>
      </el-table-column>
      <el-table-column label="颁发人/报道人" align="center" prop="issuedPerson" />
      <el-table-column label="颁发时间/报道时间" align="center" prop="issuedTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.issuedTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="荣誉图片" align="center" prop="honorPictures" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.honorPictures" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:honors:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:honors:remove']"
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

    <!-- 添加或修改安全荣誉管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="荣誉名称" prop="honoraryName">
          <el-select v-model="form.honoraryName" placeholder="请选择荣誉名称">
            <el-option
              v-for="dict in dict.type.honorary_name"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="荣誉类型" prop="honoraryType">
          <el-select v-model="form.honoraryType" placeholder="请选择荣誉类型">
            <el-option
              v-for="dict in dict.type.honorary_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属监控中心" prop="belongMonitorCenter">
          <el-select
              size="small"
              v-model="form.belongMonitorCenter"
              filterable
              placeholder="请选择所属监控中心"
              style="width: 183px"
              @change="handleSelectMonitorCenterChange"
          >
            <el-option
                v-for="item in monitorCenters"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="颁发单位/报道单位" prop="issuedUnits">
          <el-select v-model="form.issuedUnits" placeholder="请选择颁发单位/报道单位">
            <el-option
              v-for="dict in dict.type.issued_units"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="颁发人/报道人" prop="issuedPerson">
          <el-input v-model="form.issuedPerson" placeholder="请输入颁发人/报道人" />
        </el-form-item>
        <el-form-item label="颁发时间/报道时间" prop="issuedTime">
          <el-date-picker clearable
            v-model="form.issuedTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择颁发时间/报道时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="荣誉图片" prop="honorPictures">
          <image-upload v-model="form.honorPictures"/>
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
import { listHonors, getHonors, delHonors, addHonors, updateHonors } from "@/api/system/honors";
import {selectSysMonitorCenterName} from "@/api/system/center"
import {getCompanyName} from "@/api/system/company";

export default {
  name: "Honors",
  dicts: ['honorary_type', 'sys_common_switch', 'issued_units', 'honorary_name'],
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
      // 安全荣誉管理表格数据
      honorsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        honoraryName: null,
        honoraryType: null,
        belongMonitorCenter: null,
        issuedUnits: null,
        issuedPerson: null,
        issuedTime: null,
      },
      // 表单参数
      form: {},
      monitorCenters:[],
      // 表单校验
      rules: {
        honoraryName: [
          { required: true, message: "荣誉名称不能为空", trigger: "change" }
        ],
        honoraryType: [
          { required: true, message: "荣誉类型不能为空", trigger: "change" }
        ],
        belongMonitorCenter: [
          { required: true, message: "所属监控中心不能为空", trigger: "change" }
        ],
        issuedUnits: [
          { required: true, message: "颁发单位/报道单位不能为空", trigger: "change" }
        ],
        issuedPerson: [
          { required: true, message: "颁发人/报道人不能为空", trigger: "blur" }
        ],
        issuedTime: [
          { required: true, message: "颁发时间/报道时间不能为空", trigger: "blur" }
        ],
        honorPictures: [
          { required: true, message: "荣誉图片不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.initMonitorCenterList();
  },
  methods: {
    /** 查询安全荣誉管理列表 */
    getList() {
      this.loading = true;
      listHonors(this.queryParams).then(response => {
        this.honorsList = response.rows;
        this.total = response.total;
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
        honoraryName: null,
        honoraryType: null,
        belongMonitorCenter: null,
        issuedUnits: null,
        issuedPerson: null,
        issuedTime: null,
        remark: null,
        honorPictures: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
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
      this.open = true;
      this.title = "添加安全荣誉管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      this.initMonitorCenterList();
      getHonors(id).then(response => {
        this.form = response.data;
        this.form.belongMonitorCenter = Number(this.form.belongMonitorCenter)
        this.open = true;
        this.title = "修改安全荣誉管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateHonors(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHonors(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除安全荣誉管理编号为"' + ids + '"的数据项？').then(function() {
        return delHonors(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/honors/export', {
        ...this.queryParams
      }, `honors_${new Date().getTime()}.xlsx`)
    },
    handleSelectMonitorCenterChange(value){
      console.log('Selected Value:', value);
      this.form.belongMonitorCenter = value;
    },
    initMonitorCenterList(){
      this.queryParams.pageSize=1000
      selectSysMonitorCenterName(this.queryParams).then(response => {
        this.monitorCenters = response.data
      });
    },
  }
};
</script>
