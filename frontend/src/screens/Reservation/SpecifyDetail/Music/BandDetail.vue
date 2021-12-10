<template>
    <div class="mt-4">
        <h4 class="fw-light">กรุณาเลือกวงดนตรี</h4>
        <div>รายชื่อวงดนตรีที่สามารถขึ้นเล่นได้ในวันที่ {{date}}</div>
    </div>
</template>
<script>
export default {
    props: {
        date: {
            type: String
        }
    },
    data() {
        return {

        }
    }
}
</script>