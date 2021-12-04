<template>
    <div id="confirmationModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-body text-center p-5">
                    <div class="mb-5">
                        <h4 class="fw-light">ดำเนินการจองห้อง</h4>
                        <h2 class="fw-bold text-emerald my-3">{{reservation.room.title}}</h2>
                        <h4 class="fw-light">{{reserveDate}}</h4>
                    </div>
                    <button class="btn btn-outline-secondary px-5 py-2 mx-1 fw-light">ยกเลิก</button>
                    <button class="btn btn-lighter-emerald px-5 py-2 mx-1 fw-light">ดำเนินการต่อ</button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import dayjs from 'dayjs'

export default {
    props: {
        reservation: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            modal: null
        }
    },
    computed: {
        reserveDate() {
            const date = this.reservation.date
            const startAt = this.reservation.startAt
            const endAt = this.reservation.endAt

            let formattedDate = dayjs(date, 'YYYY-MM-DD').format('DD/MM/YYYY')
            let formattedStart = dayjs(`${date} ${startAt}:00`, 'YYYY-MM-DD H:mm').format('HH:mm')
            let formattedEnd = dayjs(`${date} ${endAt}:00`, 'YYYY-MM-DD H:mm').format('HH:mm')
            return `ในวันที ${formattedDate} เวลา ${formattedStart} ถึง ${formattedEnd}`
        }
    },
    mounted() {
        const element = document.getElementById('confirmationModal')
        this.modal = new bootstrap.Modal(element, {keyboard: false})
    },
    methods: {
        toggle() {
            this.modal.toggle()
        },
        confirm() {
            this.modal.hide()
        }
    }
}
</script>