<template>
    <div class="mt-4">
        <h4 class="fw-light">กรุณาเลือกวงดนตรี</h4>
        <div>รายชื่อวงดนตรีที่สามารถขึ้นเล่นได้ในวันที่ {{formattedDate}}</div>
        <div class="mt-4">

        </div>
    </div>
</template>
<script>
import dayjs from 'dayjs'
export default {
    props: {
        date: {
            type: String
        }
    },
    computed: {
        formattedDate() {
            return this.date ? dayjs(this.date).format('DD MMM YYYY') : ''
        }
    },
    data() {
        return {

        }
    }
}
</script>