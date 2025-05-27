int main() {
    int count = 0;
    int even_gt_2 = 0;
    int odd_gt_2 = 0;
    int value = 0;

    while (count < 10000000) {
        value = count % 10;
        if (value > 2) {
            if (value % 2 == 0) {
                even_gt_2 = even_gt_2 + 1;
            } else {
                odd_gt_2 = odd_gt_2 + 1;
            }
        }

        count = count + 1;
    }

    printf("10_000_000회 반복 중 조건 만족 횟수:\n");
    printf("- value > 2 이면서 짝수: %d회\n", even_gt_2);
    printf("- value > 2 이면서 홀수: %d회\n", odd_gt_2);

    return 0;
}
