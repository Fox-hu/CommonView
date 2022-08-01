

import android.view.View
import com.fox.commonview.stateslayout.StateLayout
import com.fox.commonview.stateslayout.StateParam

/**
 * created by francis.fan on 2019/12/9
 *
 */
class NormalLayout constructor(val view: View) : StateLayout {


    override fun getStateView(): View {
        return view
    }

    override fun bindData(stateParam: StateParam) {

    }
}